import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[][] dp;
    static int m;
    static int n;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        map = new int[m][n];
        dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        dfs(0, 0);

        System.out.println(dp[0][0]);
    }


    private static int dfs(int x, int y) {
        if (x == m - 1 && y == n - 1) {
            return 1;
        }
        if (dp[x][y] != -1) {
            return dp[x][y];
        }

        int c = 0;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < m && nowY < n) {
                if (map[x][y] > map[nowX][nowY]) {
                    c += dfs(nowX, nowY);
                }
            }
        }

        return dp[x][y] = c;
    }
}