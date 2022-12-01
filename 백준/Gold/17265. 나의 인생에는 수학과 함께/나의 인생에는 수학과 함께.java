import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int n;
    static int dx[] = {1, 0};
    static int dy[] = {0, 1};
    static ArrayList<Integer> nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        map = new char[n][n];
        visit = new boolean[n][n];
        nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j * 2);
            }
        }

        dfs(0, 0, map[0][0] - '0');

        System.out.println(Collections.max(nums) + " " + Collections.min(nums));
    }

    private static void dfs(int x, int y, int v) {
        if (x == n - 1 && y == n - 1) {
            nums.add(v);
            return;
        }

        visit[x][y] = true;

        for (int i = 0; i < 2; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                if (!visit[nowX][nowY])
                    if (map[x][y] == '+') {
                        dfs(nowX, nowY, v + (map[nowX][nowY] - '0'));
                    } else if (map[x][y] == '-') {
                        dfs(nowX, nowY, v - (map[nowX][nowY] - '0'));
                    } else if (map[x][y] == '*') {
                        dfs(nowX, nowY, v * (map[nowX][nowY] - '0'));
                    } else
                        dfs(nowX, nowY, v);
            }
        }

        visit[x][y] = false;
    }
}
