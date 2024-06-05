
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             DatagramSocket socket = new DatagramSocket()) {

            InetAddress serverAddress = InetAddress.getLocalHost();

            while (true) {
                String input = scanner.nextLine();
                byte[] buffer = input.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, serverAddress, 1234);
                socket.send(sendPacket);

                if (input.equals("bye")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
