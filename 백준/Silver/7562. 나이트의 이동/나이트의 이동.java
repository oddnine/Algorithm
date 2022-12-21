import java.util.*;

public class Main {
    static boolean[][] map;
    static int dx[] = {2, 1, -1, -2, -2, -1, 1, 2};
    static int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
    static int n;
    static int ex;
    static int ey;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            map = new boolean[n][n];

            int sx = sc.nextInt();
            int sy = sc.nextInt();
            map[sx][sy] = true;

            ex = sc.nextInt();
            ey = sc.nextInt();
            map[ex][ey] = true;

            System.out.println(bfs(sx, sy));
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0});
        boolean[][] visit = new boolean[n][n];
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] list = q.poll();
            int cx = list[0];
            int cy = list[1];
            int cc = list[2];

            for (int i = 0; i < 8; i++) {
                int nowX = cx + dx[i];
                int nowY = cy + dy[i];
                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                    if (!visit[nowX][nowY]) {
                        if (nowX == ex && nowY == ey) {
                            cc++;
                            return cc;
                        } else {
                            visit[nowX][nowY] = true;
                            q.add(new int[]{nowX, nowY, cc + 1});
                        }
                    }
                }
            }
        }
        return 0;
    }
}