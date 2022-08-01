import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long a = scanner.nextLong();
        long b = scanner.nextLong();

        if (a < 0) {
            a = a - a - a;
            System.out.println(Math.abs(a + b));
            return;
        }
        System.out.println(Math.abs(b - a));
        return;
    }
}