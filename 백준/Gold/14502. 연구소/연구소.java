import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 벽을 3개를 세운다.
        // 바이러스를 퍼뜨린다
        // 0의 갯수를 구한다.
        // -> 이 값을 max값과 계속 비교하면서 최대값을 구한다.

        Scanner scanner = new Scanner(System.in);
        Y = scanner.nextInt();
        X = scanner.nextInt();
        //맨 윗줄이 y값이 Y-1 좌표부터 시작하니까
        for (int y = Y - 1; y >= 0; y--) {
            //왼쪽부터 x값을 받으니까 0부터 시작
            for (int x = 0; x < X; x++) {
                map[x][y] = scanner.nextInt();
            }
        }

        recursive(0);
        System.out.println(max);
    }

    public static int map[][] = new int[8][8];
    public static int X;
    public static int Y;
    public static int max = 0;

    public static void recursive(int index) {
        //탈출 조건
        if (index == 3) {
            //바이러스를 퍼뜨려 본다.
            //남아있는 0의 갯수를 센다.
            int countOf0 = bfs();
            max = Math.max(max, countOf0);
            return;
        }

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 0) { //벽을 세울 수 있다.
                    map[i][j] = 1; //벽을 세우고
                    recursive(index + 1);
                    map[i][j] = 0; //벽을 다시 치우기
                }
            }
        }
    }

    public static int dx[] = new int[]{0, 0, 1, -1};
    public static int dy[] = new int[]{1, -1, 0, 0};

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] check = new boolean[X][Y];

        //2인 위치를 bfs의 시작위치로 하자
        // = q에 넣고 시작
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] list = q.poll();
            int curx = list[0];
            int cury = list[1];

            for (int i = 0; i < 4; i++) {
                int nx = curx + dx[i];
                int ny = cury + dy[i];

                if (0 <= nx && nx < X && ny >= 0 && ny < Y && !check[nx][ny] && map[nx][ny] == 0) {
                    check[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        //안전영역의 갯수 구하기
        int count = 0;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (map[i][j] == 0 && !check[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}