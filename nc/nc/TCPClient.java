import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 5000);
             BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            System.out.println("Connected");
            String line;
            while (!(line = input.readLine()).equalsIgnoreCase("BYE")) {
                writer.write(line + "\n");
                writer.flush();
                System.out.println("Server: " + reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
