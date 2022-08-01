import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        a = reverse(a);
        b = reverse(b);

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    public static int reverse(int num) {
        String n = String.valueOf(num);
        String temp = new String();

        for (int i = n.length() - 1; i >= 0; i--) {
            temp += n.charAt(i);
        }
        return Integer.parseInt(temp);
    }
}