import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class HTTPWEBServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(3000);
             Socket socket = server.accept()) {

            System.out.println("Server waiting for image...");
            InputStream in = socket.getInputStream();
            BufferedImage image = ImageIO.read(in);

            JFrame frame = new JFrame("Received Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new JLabel(new ImageIcon(image)));
            frame.pack();
            frame.setVisible(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
