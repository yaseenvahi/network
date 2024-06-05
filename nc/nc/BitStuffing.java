import java.util.*;

public class BitStuffing{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String d1 = sc.nextLine();
        String remaining = new String();
        String output = new String();
        int counter = 0;

        for (int i = 0; i < d1.length(); i++) {
            if (d1.charAt(i) != '1' && d1.charAt(i) != '0') {
                System.out.println("Enter valid Binary values");
                return;
            }
            if (d1.charAt(i) == '1') {
                counter++;
                remaining = remaining + d1.charAt(i);
            } else {
                remaining = remaining + d1.charAt(i);
                counter = 0;
            }
            if (counter == 5) {
                remaining = remaining + '0';
                counter = 0;
            }
        }
        System.out.println("Flag --> 01111110");
        String new1 = "|01111110 | " + remaining + " | 01111110|";
        System.out.println("Stuffed data at intermediate site is:");
        counter = 0;
        for (int i = 0; i < remaining.length(); i++) {
            if (remaining.charAt(i) == '1') {
                counter++;
                output = output + remaining.charAt(i);
            } else {
                output = output + remaining.charAt(i);
                counter = 0;
            }
        }
        System.out.println("Destuffed bit: " + output);
    }
}
