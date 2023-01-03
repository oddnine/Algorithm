import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][][] map = new int[3][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '1') {
                    for (int k = 0; k < 3; k++) {
                        map[k][i][j] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            map[i][x][y]++;
            bfs(x, y, map[i]);
        }

        int s = 99999;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[0][i][j] != -1 && map[0][i][j] != 0 && map[1][i][j] != 0 && map[2][i][j] != 0) {
                    int temp = Math.max(Math.max(map[0][i][j], map[1][i][j]), map[2][i][j]);
                    if (s > temp) {
                        s = temp;
                        c = 1;
                    } else if (s == temp) {
                        c++;
                    }
                }
            }
        }

        if (c != 0) {
            System.out.println(s - 1);
            System.out.println(c);
        } else {
            System.out.println(-1);
        }
    }

    private static void bfs(int x, int y, int[][] map) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 1});
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int xx = poll[0];
            int yy = poll[1];
            int cc = poll[2];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (!visit[nowX][nowY] && map[nowX][nowY] != -1) {
                        q.add(new int[]{nowX, nowY, cc + 1});
                        visit[nowX][nowY] = true;
                        map[nowX][nowY] = cc + 1;
                    }
                }
            }
        }
    }
}