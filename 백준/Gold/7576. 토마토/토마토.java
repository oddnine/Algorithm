//BFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }

        try {
            bfs();
        } catch (Exception e) {
            System.out.println(-1);
            return;
        }

        int k = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                k = Math.max(k, map[i][j]);
            }
        }

        System.out.println(k - 1);
    }

    private static void bfs() {
        int[] point = q.poll();
        int x = point[0];
        int y = point[1];
        visited[x][y] = true;
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] list = q.poll();
            int xx = list[0];
            int yy = list[1];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (!visited[nowX][nowY] && map[nowX][nowY] == 0) {
                        map[nowX][nowY] = map[xx][yy] + 1;
                        visited[nowX][nowY] = true;
                        q.add(new int[]{nowX, nowY, map[xx][yy] + 1});
                    }
                }
            }
        }

        visited = new boolean[n][m];
    }
}