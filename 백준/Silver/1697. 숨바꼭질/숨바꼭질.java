import java.io.*;
import java.util.*;

public class Main {
    static int visited[] = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(bfs(n, k));
    }

    private static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int num = q.poll();

            if (num == k) {
                return visited[num] - 1;
            }

            if (num + 1 <= 100000 && visited[num + 1] == 0) {
                visited[num + 1] = visited[num] + 1;
                q.add(num + 1);
            }

            if (num - 1 >= 0 && visited[num - 1] == 0) {
                visited[num - 1] = visited[num] + 1;
                q.add(num - 1);
            }

            if (num * 2 <= 100000 && visited[num * 2] == 0) {
                visited[num * 2] = visited[num] + 1;
                q.add(num * 2);
            }
        }
        return -1;
    }

}
