import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static int n;
    static ArrayList<Integer> parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            n = sc.nextInt();

            map = new ArrayList[n];
            visit = new boolean[n];
            parent = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                map[j] = new ArrayList<>();
            }

            int a = 0;
            int b = 0;

            for (int j = 0; j < n - 1; j++) {
                a = sc.nextInt() - 1;
                b = sc.nextInt() - 1;

                map[b].add(a);
            }

            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;

            ArrayList<Integer> aParent = dfs(a);
            parent = new ArrayList<>();
            visit = new boolean[n];
            ArrayList<Integer> bParent = dfs(b);
            parent = new ArrayList<>();
            visit = new boolean[n];

            boolean check = false;

            for (int j = aParent.size() - 1; j >= 0; j--) {
                for (int k = bParent.size() - 1; k >= 0; k--) {
                    if (aParent.get(j).equals(bParent.get(k))) {
                        nums.add(aParent.get(j) + 1);
                        check = true;
                        break;
                    }
                }
                if (check)
                    break;
            }
        }

        for (Integer num : nums) {
            System.out.println(num);
        }
    }

    private static ArrayList<Integer> dfs(int start) {
        visit[start] = true;


        for (int i = 0; i < map[start].size(); i++) {
            if (!visit[map[start].get(i)] && map[start].size() != 0) {
                dfs(map[start].get(i));
            }
        }

        parent.add(start);

        return parent;
    }
}
