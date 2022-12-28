import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] prime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        setPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            bfs(s, e);
        }
    }

    private static void bfs(int start, int end) {
        boolean[] visited = new boolean[10000];
        Queue<Integer> q = new LinkedList<>();
        int[] count = new int[10000];

        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int num = q.poll();

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    if (i == 0 && j == 0)
                        continue;

                    StringBuilder sb = new StringBuilder(String.valueOf(num));
                    sb.setCharAt(i, (char) (j + '0'));
                    int temp = Integer.parseInt(sb.toString());

                    if (!visited[temp] && !prime[temp]) {
                        q.add(temp);
                        visited[temp] = true;
                        count[temp] = count[num] + 1;
                    }
                }
            }
        }
        System.out.println(count[end]);
    }

    private static void setPrime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i * i <= 9999; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 9999; j += i)
                    prime[j] = true;
            }
        }
    }
}