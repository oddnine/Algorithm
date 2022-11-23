import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int col, row, ans;
    static int[][] map;
    static boolean[][] visited;
    static boolean pick;
    static int dx[] = {-1, 1, 0, 0, 1, 1, -1, -1};
    static int dy[] = {0, 0, -1, 1, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        map = new int[col][row];
        visited = new boolean[col][row];

        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (!visited[i][j]) {
                    pick = true;
                    dfs(i, j);
                    if (pick) ans++;
                }
            }
        }

        System.out.println(ans);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int k = 0; k < 8; k++) {
            int nowX = x + dx[k];
            int nowY = y + dy[k];
            if (nowX < 0 || nowY < 0 || nowX >= col || nowY >= row) continue;
            if (map[nowX][nowY] > map[x][y]) pick = false;
            if (!visited[nowX][nowY] && map[nowX][nowY] == map[x][y]) {
                dfs(nowX, nowY);
            }
        }
    }

}