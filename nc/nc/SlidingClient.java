import java.io.*;
import java.net.*;

class SlidingClient{
    public static void main(String args[]){
        try{
            Socket soc = new Socket("localhost", 1234); 
            System.out.println("Waiting...");

            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            for (int i = 0; i < 10; i++){
                out.println("Packet" + i); // Send a message to the server
                System.out.println("Packet" + i);
                System.out.println("Response: " + in.readLine());
            }

            soc.close();
            System.out.println("Disconnected");
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
