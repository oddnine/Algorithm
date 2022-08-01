import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        char[] nums = st.nextToken().toCharArray();
        n = 0;
        for (int i = 0; i < nums.length; i++) {
            n += Character.getNumericValue(nums[i]);
        }

        System.out.println(n);
    }
}