import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Integer> nums = new ArrayList<>();

        int total = 0;

        for (int i = m; i <= n; i++) {
            int sign = 0;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    sign = 1;
                    break;
                }
            }
            if (sign != 1 && i != 1) {
                nums.add(i);
                total += i;
            }
        }

        if (total == 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(total);
        System.out.println(Collections.min(nums));
    }
}