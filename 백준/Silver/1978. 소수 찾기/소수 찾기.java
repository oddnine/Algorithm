import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Integer> nums = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (prime(nums.get(i)) == true && !nums.get(i).equals(1) && !nums.get(i).equals(0))
                count++;
        }
        System.out.println(count);
    }

    public static boolean prime(int num) {
        for (int j = 2; j * j <= num; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}