import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] map;
    static boolean[] visit;
    static int count;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new boolean[n][n];
        visit = new boolean[n];
        count = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            map[a][b] = true;
            map[b][a] = true;
        }

        dfs(0);

        System.out.println(count);
    }

    static public void dfs(int start) {
        visit[start] = true;

        for (int i = 0; i < n; i++) {
            if (!visit[i] && map[start][i]) {
                dfs(i);
                count++;
            }
        }
    }
}