import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static ArrayList<Bridge>[] map;
    static boolean[] visit;
    static int N = 10001;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new ArrayList[N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            map[i] = new ArrayList<>();
        }

        while (true) {
            int a = 0;
            int b = 0;
            int c = 0;

            try {
                String str = sc.nextLine();
                String[] nums = str.split(" ");
                a = Integer.parseInt(nums[0]) - 1;
                b = Integer.parseInt(nums[1]) - 1;
                c = Integer.parseInt(nums[2]);

            } catch (Exception e) {
                break;
            }

            map[a].add(new Bridge(b, c));
            map[b].add(new Bridge(a, c));
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0);
        }

        System.out.println(count);
    }

    private static void dfs(int start, int c) {
        visit[start] = true;

        for (int i = 0; i < map[start].size(); i++) {
            if (!visit[map[start].get(i).getCity()]) {
                dfs(map[start].get(i).getCity(), c + map[start].get(i).getCost());
            }
            if (visit[map[start].get(i).getCity()]) {
                count = Math.max(c, count);
            }
        }
        visit[start] = false;
    }
}

class Bridge {
    int city;
    int cost;

    public Bridge(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
