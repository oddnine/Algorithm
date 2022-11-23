import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static char[][] map;
    static List<Character> checkedAlphabet;
    static int r;
    static int c;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        map = new char[r][c];
        checkedAlphabet = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        max = 0;
        dfs(0, 0, 0);

        System.out.println(max);
    }


    private static void dfs(int x, int y, int count) {
        if (checkedAlphabet.contains(map[x][y])) {
            max = Math.max(max, count);
            return;
        }

        checkedAlphabet.add(map[x][y]);

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < r && nowY < c) {
                dfs(nowX, nowY, count + 1);
            }
        }

        checkedAlphabet.remove(Character.valueOf(map[x][y]));
    }
}
