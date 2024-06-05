import java.io.*;
import java.net.*;

class SlidingServer{
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(1234);
            System.out.println("Running");

            while (true) {
                Socket client = server.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintWriter out = new PrintWriter(client.getOutputStream(), true);

                String re;
                while ((re = in.readLine()) != null) {
                    System.out.println("received: " + re);
                    out.println("Response to: " + re); // Send response back to the client
                }

                client.close();
                System.out.println("Disconnected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
