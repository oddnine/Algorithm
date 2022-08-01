import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        System.out.println(j(n));
    }

    public static int j(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return j(n - 1) + j(n - 2);
    }
}