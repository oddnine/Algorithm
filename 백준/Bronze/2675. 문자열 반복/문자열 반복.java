import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            char[] s = st.nextToken().toCharArray();
            for (int j = 0; j < s.length; j++) {
                for (int k = 0; k < r; k++) {
                    System.out.print(s[j]);
                }
            }
            System.out.println();
        }
    }
}