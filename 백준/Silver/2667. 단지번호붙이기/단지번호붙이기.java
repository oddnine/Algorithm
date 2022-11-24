import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] map;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static List<Integer> nums;
    static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        map = new boolean[n][n];
        visited = new boolean[n][n];
        nums = new ArrayList<>();
        c = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            for (int j = 0; j < n; j++) {
                char c = a.charAt(j);
                if (c != '0') {
                    map[i][j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j]) {
                    dfs(i, j);
                    count++;
                    nums.add(c);
                    c = 0;
                }
            }
        }

        System.out.println(count);
        Collections.sort(nums);
        for (Integer num : nums) {
            System.out.println(num + 1);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                if (!visited[nowX][nowY] && map[nowX][nowY]) {
                    dfs(nowX, nowY);
                    c++;
                }
            }
        }
    }
}