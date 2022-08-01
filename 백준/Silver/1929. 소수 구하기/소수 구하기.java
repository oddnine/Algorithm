import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();

        for (int i = n; i <= m; i++) {
            int sign = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    sign = 1;
                    break;
                }
            }
            if (sign != 1 && i != 1) {
                nums.add(i);
            }
        }

        for (int n2 : nums) {
            System.out.println(n2);
        }
    }
}