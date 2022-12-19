import java.util.*;

public class Main {
    static int[][] map;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int n;
    static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        int day = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = sc.nextInt();
                if (num == 0) {
                    map[i][j] = 9;
                } else {
                    map[i][j] = 5;
                }
            }
        }

        while (true) {
            bfs(0, 0);

            int count = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] <= 3) {
                        map[i][j] = 9;
                        count++;
                    }
                    if (map[i][j] == 4) {
                        map[i][j] = 5;
                    }
                }
            }

            if (count == 0)
                break;

            day++;
        }

        System.out.println(day);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;
        while (!q.isEmpty()) {
            int[] list = q.poll();
            int cx = list[0];
            int cy = list[1];

            for (int i = 0; i < 4; i++) {
                int nowX = cx + dx[i];
                int nowY = cy + dy[i];
                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (map[nowX][nowY] <= 5) {
                        map[nowX][nowY]--;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nowX = cx + dx[i];
                int nowY = cy + dy[i];
                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (!visit[nowX][nowY] && map[nowX][nowY] == 9) {
                        visit[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY});
                    }
                }
            }
        }
    }
}