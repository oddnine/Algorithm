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
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[n][m];
        nums = new ArrayList<>();
        count = 0;

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
                    dfs(i, j);
                    nums.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(nums);
        System.out.println(nums.size());
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                if (!visited[nowX][nowY] && !map[nowX][nowY]) {
                    dfs(nowX, nowY);
                }
            }
        }
    }
}