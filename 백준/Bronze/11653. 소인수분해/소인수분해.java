import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int i = 2;
        while (n != -1) {
            if (n % i == 0) {
                System.out.println(i);
                n /= i;
            } else {
                i++;
            }
            if (i > n) {
                return;
            }
        }
    }
}