import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] map;
    static boolean[] visit;
    static int n;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new ArrayList[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();

            map[a].add(new Node(b, d));
            map[b].add(new Node(a, d));
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i])
                dfs(i, 0);
        }

        System.out.println(max);
    }

    private static void dfs(int start, int d) {
        if (d > max) {
            max = d;
            return;
        }
        visit[start] = true;

        for (int i = 0; i < map[start].size(); i++) {
            if (!visit[map[start].get(i).next]) {
                dfs(map[start].get(i).next, d + map[start].get(i).dist);
            }
        }

        visit[start] = false;
    }
}

class Node {
    int next;
    int dist;

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }
}