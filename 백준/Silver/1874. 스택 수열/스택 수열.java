import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int count = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();

        List<String> chars = new ArrayList<>();

        int max = 0;
        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();

            if (num > max) {
                for (int j = max + 1; j <= num; j++) {
                    stack.push(j);
                    chars.add("+");
                }
                max = num;
            } else if (stack.peek() != num) {
                System.out.println("NO");
                return;       
            }

            stack.pop();
            chars.add("-");
        }

        for (int i = 0; i < chars.size(); i++) {
            System.out.println(chars.get(i));
        }
    }
}