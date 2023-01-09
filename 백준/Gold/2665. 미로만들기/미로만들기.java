import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] map;
    static int[][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new boolean[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < n; j++) {
                if (split[j].equals("1"))
                    map[i][j] = true;
                else
                    map[i][j] = false;
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs(0, 0);

        System.out.println(visited[n - 1][n - 1]);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int xx = node[0];
            int yy = node[1];

            for (int i = 0; i < 4; i++) {
                int nowX = xx + dx[i];
                int nowY = yy + dy[i];

                if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                    if (visited[nowX][nowY] > visited[xx][yy]) {
                        if (map[nowX][nowY]) {
                            q.add(new int[]{nowX, nowY});
                            visited[nowX][nowY] = visited[xx][yy];
                        } else {
                            q.add(new int[]{nowX, nowY});
                            visited[nowX][nowY] = visited[xx][yy] + 1;
                        }
                    }
                }
            }
        }
    }
}
