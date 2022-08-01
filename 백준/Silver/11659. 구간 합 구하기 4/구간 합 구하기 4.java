import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n + 1];
        long[] sum = new long[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                sum[i] = arr[i];
            } else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1) {
                sb.append(sum[b]).append("\n");
            } else {
                sb.append(sum[b] - sum[a - 1]).append("\n");
            }
            //int total = 0;


            //for (int j = a - 1; j < b; j++) {
            //    total += arr[j];
            //}
            //bw.write(String.valueOf(total) + "\n");
        }
        System.out.println(sb);
    }
}