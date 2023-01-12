import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            for (int k = i; k < n - 1; k++) {
                System.out.print(" ");
            }
            for (int j = -1; j < i * 2; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
