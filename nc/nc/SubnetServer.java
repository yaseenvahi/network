import java.io.*;
import java.net.*;

public class SubnetServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server listening on port 12345...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String ipAddress = in.readLine();
                    out.println("Available subnet range: " + ipAddress.substring(0, ipAddress.lastIndexOf('.') + 1) + "0 - " + ipAddress.substring(0, ipAddress.lastIndexOf('.') + 1) + "255");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}