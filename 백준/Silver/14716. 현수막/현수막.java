import java.util.Scanner;

public class Main {
    static boolean[][] map;
    static boolean[][] visit;
    static int n;
    static int m;
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new boolean[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                if (num == 1) {
                    map[i][j] = true;
                }
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                if (!visit[nowX][nowY] && map[nowX][nowY]) {
                    dfs(nowX, nowY);
                }
            }
        }
    }
}