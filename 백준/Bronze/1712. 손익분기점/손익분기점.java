import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        if (b >= c) {
            System.out.println(-1);
            return;
        }
        int temp = a / (c - b);
        if (temp < 0) {
            System.out.println(-1);
        } else if (temp >= 0) {
            System.out.println(temp + 1);
        }
        return;
    }
}