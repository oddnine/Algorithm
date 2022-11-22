import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int[][] ground;
    static boolean[][] check;
    static int m;
    static int n;
    static int[] dx = {0, 0, -1, +1};
    static int[] dy = {-1, +1, 0, 0};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();

            ground = new int[m][n];
            check = new boolean[m][n];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                ground[x][y] = 1;
            }

            int count = 0;

            for (int j = 0; j < m; j++) {
                for (k = 0; k < n; k++) {
                    if (ground[j][k] == 1 && !check[j][k]) {
                        dfs(j, k);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int startX, int startY) {
        check[startX][startY] = true;

        for (int i = 0; i < 4; i++) {
            int x = startX + dx[i];
            int y = startY + dy[i];

            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }

            if (ground[x][y] == 1 && !check[x][y]) {
                dfs(x, y);
            }
        }
    }
}
