import java.io.*;
import java.util.*;

public class Main {
    static boolean map[][];
    static int visited[][];
    static int n, m, k;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new int[n][m];
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == '#') {
                    map[i][j] = true;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int sx = Integer.parseInt(st.nextToken()) - 1;
        int sy = Integer.parseInt(st.nextToken()) - 1;
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;

        bfs(sx, sy, ex, ey);
        visited[ex][ey] = visited[ex][ey] == 0 ? -1 : visited[ex][ey];
        System.out.println(visited[ex][ey]);
    }

    private static void bfs(int sx, int sy, int ex, int ey) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                for (int j = 1; j <= k; j++) {
                    int nowX = x + dx[i] * j;
                    int nowY = y + dy[i] * j;

                    if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m && !map[nowX][nowY]) {
                        if (visited[nowX][nowY] == 0) {
                            visited[nowX][nowY] = visited[x][y] + 1;
                            if (nowX == ex && nowY == ey)
                                return;
                            q.add(new int[]{nowX, nowY});
                        } else if (visited[nowX][nowY] <= visited[x][y])
                            break;
                    } else
                        break;
                }
            }
        }
    }
}
