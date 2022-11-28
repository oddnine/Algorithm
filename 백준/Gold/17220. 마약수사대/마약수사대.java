import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] check;
    static int n;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        map = new ArrayList[n];
        check = new boolean[n];
        count = 0;

        int[] tempHeader = new int[n]; //0이면 마약 공급책
        List<Integer> header = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = String.valueOf(sc.next()).charAt(0) - 'A';
            int b = String.valueOf(sc.next()).charAt(0) - 'A';
            map[a].add(b);
            tempHeader[b]++;
        }

        for (int i = 0; i < tempHeader.length; i++) {
            if (tempHeader[i] == 0) {
                header.add(i);
            }
        }

        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = String.valueOf(sc.next()).charAt(0) - 'A';

            map[a].clear();
            if (!header.contains(a)) {
                for (int j = 0; j < map.length; j++) {
                    map[j].remove(Integer.valueOf(a));
                }
            }
        }

        for (int i = 0; i < tempHeader.length; i++) {
            if (tempHeader[i] == 0) {
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        check[start] = true;

        for (int i = 0; i < map[start].size(); i++) {
            if (!check[map[start].get(i)]) {
                dfs(map[start].get(i));
                count++;
            }
        }
    }
}
