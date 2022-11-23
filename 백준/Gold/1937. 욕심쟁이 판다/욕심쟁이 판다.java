import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int n;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = Math.max(count, dfs(i, j));
            }
        }

        System.out.println(count);
    }


    private static int dfs(int x, int y) {
        if (dp[x][y] != 0) {
            return dp[x][y];
        }

        dp[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                if (map[x][y] < map[nowX][nowY]) {
                    dp[x][y] = Math.max(dp[x][y], dfs(nowX, nowY) + 1);
                    dfs(nowX, nowY);
                }
            }
        }

        return dp[x][y];
    }
}
