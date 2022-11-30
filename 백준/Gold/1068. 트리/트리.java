import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static int n;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new ArrayList[n];
        visit = new boolean[n];
        int root = 0;
        count = 0;

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();

            if (a == -1)
                root = i;
            else
                map[a].add(i);
        }

        int d = sc.nextInt();

        if (d == root) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (map[i].contains(d)) {
                map[i].remove(Integer.valueOf(d));
            }
        }

        dfs(root);

        System.out.println(count);
    }

    private static void dfs(int start) {
        if (map[start].size() == 0) {
            count++;
            return;
        }

        visit[start] = true;

        for (int i = 0; i < map[start].size(); i++) {
            if (!visit[map[start].get(i)]) {
                dfs(map[start].get(i));
            }
        }
    }
}