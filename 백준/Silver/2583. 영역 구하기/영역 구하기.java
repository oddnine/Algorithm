import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] map;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static List<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m];
        nums = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = Integer.parseInt(st.nextToken());
            int b1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken()) - 1;
            int b2 = Integer.parseInt(st.nextToken()) - 1;


            for (int j = a1; j <= a2; j++) {
                for (int l = b1; l <= b2; l++) {
                    map[l][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && !map[i][j]) {
                    int num = bfs(i, j);
                    nums.add(num);
                }
            }
        }

        Collections.sort(nums);
        System.out.println(nums.size());
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    private static int bfs(int x, int y) {
        visited[x][y] = true;
        int count = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] list = q.poll();
            int xx = list[0];
            int yy = list[1];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (!visited[nowX][nowY] && !map[nowX][nowY]) {
                        visited[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY});
                        count++;
                    }
                }
            }
        }

        return count;
    }
}