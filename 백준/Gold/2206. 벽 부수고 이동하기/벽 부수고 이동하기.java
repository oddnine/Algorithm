import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] map;
    static boolean[][][] visited;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new boolean[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String[] split = st.nextToken().split("");
            for (int j = 0; j < m; j++) {
                if (split[j].equals("1"))
                    map[i][j] = true;
                else
                    map[i][j] = false;
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited[0][0][0] = true;

        for (int count = 1; !q.isEmpty(); count++) {
            int q_size = q.size();
            while (q_size > 0) {
                Node nn = q.poll();
                int xx = nn.x;
                int yy = nn.y;
                int w = nn.wall;

                if (xx == n - 1 && yy == m - 1) {
                    return count;
                }

                for (int i = 0; i < 4; i++) {
                    int nowX = xx + dx[i];
                    int nowY = yy + dy[i];

                    if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                        if (!visited[w][nowX][nowY]) {
                            if (!map[nowX][nowY]) {
                                visited[w][nowX][nowY] = true;
                                q.add(new Node(nowX, nowY, w));
                            } else if (w == 0) {
                                visited[1][nowX][nowY] = true;
                                q.add(new Node(nowX, nowY, 1));
                            }
                        }
                    }
                }
                q_size--;
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int wall;

        public Node(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
}