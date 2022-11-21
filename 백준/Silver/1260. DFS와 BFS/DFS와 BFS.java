import java.util.*;

public class Main {
    public static int[][] branch;
    public static boolean[] visit;
    public static Queue<Integer> q;
    public static int N;
    public static int M;
    public static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.next());
        M = Integer.parseInt(sc.next());
        V = Integer.parseInt(sc.next());

        branch = new int[1001][1001];
        visit = new boolean[1001];

        for (int i = 0; i < M; i++) {
            int a = Integer.parseInt(sc.next());
            int b = Integer.parseInt(sc.next());
            branch[a][b] = branch[b][a] = 1;
        }

        dfs(V);
        System.out.println();

        Arrays.fill(visit, false);
        bfs(V);
    }

    public static void dfs(int start) {
        visit[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i <= N; i++) {
            if (branch[start][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q = new LinkedList<>();
        q.add(start);
        visit[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < branch.length; i++) {
                if (branch[temp][i] == 1 && !visit[i]) {
                    q.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}