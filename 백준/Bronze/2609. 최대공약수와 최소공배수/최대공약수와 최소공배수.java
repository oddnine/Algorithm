import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

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

        System.out.println(n);
        System.out.println(n2 * m2 / n);


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}