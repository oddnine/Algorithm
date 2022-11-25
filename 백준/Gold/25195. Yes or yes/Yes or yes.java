import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] map;
    static List<Integer> check;
    static List<Integer> fans;
    static int n;
    static boolean tour;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        map = new ArrayList[n];
        check = new ArrayList<>();
        fans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            map[a].add(b);
        }

        int temp = sc.nextInt();
        for (int i = 0; i < temp; i++) {
            fans.add(sc.nextInt() - 1);
        }

        dfs(0);

        if (tour) {
            System.out.println("yes");
        } else {
            System.out.println("Yes");
        }
    }

    private static void dfs(int start) {
        if (fans.contains(start)) {
            return;
        }
        if (map[start].isEmpty()) {
            tour = true;
            return;
        }
        check.add(start);

        for (int i = 0; i < map[start].size(); i++) {
            if (!map[map[start].get(i)].isEmpty()) {
                dfs(map[start].get(i));
            } else if (map[map[start].get(i)].isEmpty() && !fans.contains(map[start].get(i))) {
                tour = true;
            }
        }
    }
}