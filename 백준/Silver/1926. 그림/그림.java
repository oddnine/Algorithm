import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static boolean[][] map;
    static boolean[][] visit;
    static int n;
    static int m;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int count;
    static List<Integer> big;
    static int num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new boolean[n][m];
        visit = new boolean[n][m];
        count = 0;
        num = 1;
        big = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            for (int j = 0; j < s.length; j++) {
                if (s[j].equals("1")) {
                    map[i][j] = true;
                }
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j] && map[i][j]) {
                    count++;
                    dfs(i, j);
                    big.add(num);
                    num = 1;
                }
            }
        }

        System.out.println(count);
        if (big.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(Collections.max(big));
        }
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < m) {
                if (!visit[nowX][nowY] && map[nowX][nowY]) {
                    dfs(nowX, nowY);
                    num++;
                }
            }
        }
    }
}