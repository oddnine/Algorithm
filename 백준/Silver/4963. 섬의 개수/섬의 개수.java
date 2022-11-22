import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] check;
    static int w;
    static int h;
    static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            h = sc.nextInt();
            w = sc.nextInt();
            sc.nextLine();

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[w][h];
            check = new boolean[w][h];

            for (int i = 0; i < w; i++) {
                String tempStr = sc.nextLine();
                String[] nums = tempStr.split(" ");

                for (int j = 0; j < nums.length; j++) {
                    map[i][j] = Integer.parseInt(nums[j]);
                }
            }

            int count = 0;

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (map[i][j] == 1 && !check[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nowX = x + dx[i];
            int nowY = y + dy[i];

            if (nowX >= 0 && nowY >= 0 && nowX < w && nowY < h) {
                if (map[nowX][nowY] == 1 && !check[nowX][nowY]) {
                    dfs(nowX, nowY);
                }
            }
        }
    }
}
