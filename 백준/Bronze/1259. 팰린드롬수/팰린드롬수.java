import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.equals("0"))
                return;

            String str2 = "";

            for (int i = str.length() - 1; i >= 0; i--) {
                str2 += str.charAt(i);
            }

            boolean sign = false;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != str2.charAt(i)) {
                    System.out.println("no");
                    sign = true;
                    break;
                }
            }

            if (sign) {
                continue;
            }
            System.out.println("yes");
        }
    }
}