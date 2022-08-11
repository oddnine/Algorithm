import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        bw.write(String.valueOf(Collections.max(nums)) + "\n");
        bw.write(String.valueOf(nums.indexOf(Collections.max(nums))+1));
        bw.flush();
        bw.close();
    }
}