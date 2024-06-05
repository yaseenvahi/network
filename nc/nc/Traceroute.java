import java.io.*;

public class Traceroute{
    public static void main(String[] args) {
        try {
            System.out.print("Enter the IP Address to be Traced: ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String ip = reader.readLine();

            ProcessBuilder processBuilder = new ProcessBuilder("tracert", ip); //"tracepath"
            Process process = processBuilder.start();

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = inputReader.readLine()) != null) {
                System.out.println(" " + line);
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("Error: Traceroute command failed with exit code " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
