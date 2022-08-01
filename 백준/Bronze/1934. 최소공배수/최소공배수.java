import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int n2 = n;
            int m2 = m;
            int r = 1;

            if (n < m) {
                n = m2;
                m = n2;
            }

            while (r > 0) {
                r = n % m;
                n = m;
                m = r;
            }
            sb.append(m2 * n2 / n + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}