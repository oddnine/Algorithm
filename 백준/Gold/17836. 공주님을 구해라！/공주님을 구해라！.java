import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][][] visited;
    static int n, m, t;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                String str = st.nextToken();
                if (str.equals("1")) {
                    map[i][j] = 1;
                } else if (str.equals("2")) {
                    map[i][j] = 2;
                }
            }
        }

        int result = bfs(0, 0);

        if (result == -1) {
            System.out.println("Fail");
            return;
        }

        System.out.println(result);
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, 0, 0});
        visited[0][startX][startY] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int s = poll[2];
            int c = poll[3];

            if (c > t) {
                break;
            }

            if (x == n - 1 && y == m - 1) {
                return c;
            }

            for (int i = 0; i < 4; i++) {
                int nowX = x + dx[i];
                int nowY = y + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                    if (s == 0) {
                        if (map[nowX][nowY] == 0 && !visited[0][nowX][nowY]) {
                            q.add(new int[]{nowX, nowY, s, c + 1});
                            visited[0][nowX][nowY] = true;
                        } else if ((map[nowX][nowY] == 2 && !visited[0][nowX][nowY])) {
                            q.add(new int[]{nowX, nowY, s + 1, c + 1});
                            visited[0][nowX][nowY] = true;
                        }
                    } else {
                        if (!visited[1][nowX][nowY])
                            q.add(new int[]{nowX, nowY, s, c + 1});
                        visited[1][nowX][nowY] = true;
                    }
                }
            }
        }
        return -1;
    }
}