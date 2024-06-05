import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1234)) {
            byte[] receiveData = new byte[65535];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String receivedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client: " + receivedMessage);

                if (receivedMessage.equals("bye")) {
                    System.out.println("Client sent bye... EXITING");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
