import java.io.*;
import java.net.*;

public class PingServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Server is running...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);

                BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter outputWriter = new PrintWriter(socket.getOutputStream(), true);

                for (int i = 0; i < 4; i++) {
                    String message = inputReader.readLine();
                    System.out.println("Received: " + message);
                    outputWriter.println("Reply from " + socket.getInetAddress() + "; Length " + message.length());
                }

                System.out.println("Data sent successfully.");
                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
