import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int n;
    static int m;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int ally;
    static int enemy;
    static int allyCount;
    static int enemyCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine();

        map = new char[n][m];
        visit = new boolean[n][m];
        ally = 0;
        enemy = 0;
        allyCount = 0;
        enemyCount = 0;

        try {
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < str.length(); j++) {
                    map[i][j] = str.charAt(j);
                }
            }
        } catch (Exception e) {

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, map[i][j]);
                    ally += allyCount * allyCount;
                    enemy += enemyCount * enemyCount;

                    allyCount = 0;
                    enemyCount = 0;
                }
            }
        }
        System.out.println(ally + " " + enemy);
    }

    private static void dfs(int x, int y, char t) {
        visit[x][y] = true;

        if (t == 'W')
            allyCount++;
        else
            enemyCount++;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                if (!visit[nowX][nowY] && map[nowX][nowY] == t) {
                    dfs(nowX, nowY, t);
                }
            }
        }
    }
}