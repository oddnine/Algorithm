//BFS

import java.util.*;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static int n;
    static int m;
    static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new ArrayList[n];
        visit = new boolean[n];
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            map[a].add(b);
            map[b].add(a);
        }

        bfs(0);

        for (int i = 1; i < n; i++)
            System.out.println(parent[i]);
    }

    private static void bfs(int start) {
        visit[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int num = q.remove();

            for (int i = 0; i < map[num].size(); i++) {
                if (!visit[map[num].get(i)]) {
                    visit[map[num].get(i)] = true;
                    q.add(map[num].get(i));
                    parent[map[num].get(i)] = num + 1;
                }
            }
        }
    }
}