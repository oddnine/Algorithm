import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] visit;
    static int r;
    static int c;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int tempSheep;
    static int tempWolf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();

        map = new char[r][c];
        visit = new boolean[r][c];
        int sheep = 0;
        int wolf = 0;
        tempSheep = 0;
        tempWolf = 0;

        for (int i = 0; i < r; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
                char ch = str.charAt(j);
                if (ch == 'o')
                    sheep++;
                else if (ch == 'v')
                    wolf++;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j]) {
                    dfs(i, j);

                    if (tempSheep > tempWolf)
                        wolf -= tempWolf;
                    else
                        sheep -= tempSheep;

                    tempWolf = 0;
                    tempSheep = 0;
                }
            }
        }

        System.out.print(sheep + " " + wolf);
    }

    private static void dfs(int x, int y) {
        visit[x][y] = true;

        if (map[x][y] == 'o')
            tempSheep++;
        else if (map[x][y] == 'v')
            tempWolf++;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < r && nowY < c) {
                if (!visit[nowX][nowY] && map[nowX][nowY] != '#') {
                    dfs(nowX, nowY);
                }
            }
        }
    }
}