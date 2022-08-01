import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] prime = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n2 = Integer.parseInt(st.nextToken());

            prime();
            
            boolean sign = true;
            int minNum1 = n2 / 2;
            int maxNum2 = n2 / 2;

            while (sign) {
                if (!prime[minNum1] && !prime[maxNum2]) {
                    sb.append(minNum1 + " " + maxNum2 + "\n");
                    break;
                }
                minNum1--;
                maxNum2++;
            }
        }
        System.out.println(sb);
    }

    public static void prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}