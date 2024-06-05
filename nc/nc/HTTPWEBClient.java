import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class HTTPWEBClient {
    public static void main(String[] args) {
        try (Socket soc = new Socket("localhost", 3000)) {
            System.out.println("Client is running.");

            BufferedImage image = ImageIO.read(new File("pic.jpeg"));
            ImageIO.write(image, "jpeg", soc.getOutputStream());

            System.out.println("Image sent to server.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
