import java.util.*;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            nums.add(num);
        }
        Collections.sort(nums);
        for (int n : nums
        ) {
            System.out.println(n);
        }
    }
}