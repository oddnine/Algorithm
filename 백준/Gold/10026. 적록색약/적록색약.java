import java.util.Scanner;

public class Main {
    static char[][] map;
    static boolean[][] check;
    static int n;
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static char selectedColor;
    static boolean w; //적녹색약 여부

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        map = new char[n][n];
        check = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int count = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (!check[j][k]) {
                        selectedColor = map[j][k];
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.print(count + " ");
            count = 0;
            check = new boolean[n][n];
            w = true;
        }
    }

    private static void dfs(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < n && nowY < n) {
                if (!w) {
                    if (selectedColor == map[nowX][nowY] && map[nowX][nowY] == 'R' && !check[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == map[nowX][nowY] && map[nowX][nowY] == 'G' && !check[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == map[nowX][nowY] && map[nowX][nowY] == 'B' && !check[nowX][nowY]) {
                        dfs(nowX, nowY);
                    }
                } else {
                    if ((selectedColor == 'R' || selectedColor == 'G') && (map[nowX][nowY] == 'R' || map[nowX][nowY] == 'G') && !check[nowX][nowY]) {
                        dfs(nowX, nowY);
                    } else if (selectedColor == map[nowX][nowY] && map[nowX][nowY] == 'B' && !check[nowX][nowY]) {
                        dfs(nowX, nowY);
                    }
                }
            }
        }
    }
}
