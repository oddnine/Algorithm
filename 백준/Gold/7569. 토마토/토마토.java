import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int h;
    static int n;
    static int m;
    static int[][][] map;
    static boolean[][][] visited;
    static int dx[] = {-1, 1, 0, 0, 0, 0};
    static int dy[] = {0, 0, -1, 1, 0, 0};
    static int dz[] = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];
        visited = new boolean[h][n][m];
        q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < m; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 1) {
                        q.add(new int[]{i, j, k});
                    }
                }
            }
        }

        try {
            bfs();
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }

        int max = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, map[i][j][k]);
                }
            }
        }

        System.out.println(max - 1);
    }

    private static void bfs() {
        int[] point = q.poll();
        int z = point[0];
        int x = point[1];
        int y = point[2];
        visited[z][x][y] = true;
        q.add(new int[]{z, x, y});

        while (!q.isEmpty()) {
            int[] list = q.poll();
            int zz = list[0];
            int xx = list[1];
            int yy = list[2];

            for (int i = 0; i < 6; i++) {
                int nowZ = zz + dz[i];
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowZ >= 0 && nowX >= 0 && nowY >= 0 && nowX < n && nowY < m && nowZ < h) {
                    if (!visited[nowZ][nowX][nowY] && map[nowZ][nowX][nowY] == 0) {
                        map[nowZ][nowX][nowY] = map[zz][xx][yy] + 1;
                        visited[nowZ][nowX][nowY] = true;
                        q.add(new int[]{nowZ, nowX, nowY, map[zz][xx][yy] + 1});
                    }
                }
            }
        }

        visited = new boolean[h][n][m];
    }
}