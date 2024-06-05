import java.io.*;
import java.net.*;

public class StopandWaitClient{
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            for (int i = 0; i < 10; i++) {
                out.println("Packet " + i);
                System.out.println("Sent to server: Packet " + i);
                String response = in.readLine();
                System.out.println("Response from server: " + response);
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
