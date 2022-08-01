import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(br.readLine());
            nums.add(num);
        }
        Collections.sort(nums);
        for (int n : nums
        ) {
            bw.write(String.valueOf(n) + "\n");
        }
        bw.flush();
        bw.close();
    }
}