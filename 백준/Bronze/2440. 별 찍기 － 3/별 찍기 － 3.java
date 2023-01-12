import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = n;

        for (int i = 0; i < n; i++) {
            for (int j = t; j > 0; j--) {
                System.out.print("*");
            }
            t--;
            System.out.println();
        }
    }
}