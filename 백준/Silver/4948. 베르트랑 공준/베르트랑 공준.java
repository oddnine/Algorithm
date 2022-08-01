import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int n2 = n * 2;

        int nums = 2;
        int count = 0;

        int sign = 0;

        while (n != 0) {
            if (n == 1) {
                System.out.println(1);
            } else {
                for (int i = n + 1; i < n2; i++) {
                    while (nums * nums <= i) {
                        if (i % nums == 0) {
                            sign = 1;
                            break;
                        }
                        nums++;
                    }
                    if (sign == 0) {
                        count++;
                    }
                    nums = 2;
                    sign = 0;
                }
                System.out.println(count);
                count = 0;
            }
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            n2 = n * 2;
        }
    }
}