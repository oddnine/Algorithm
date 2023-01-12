import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int t = n;
        int s = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < s; k++) {
                System.out.print(" ");
            }
            for (int j = t; j > 0; j--) {
                System.out.print("*");
            }
            t--;
            s++;
            System.out.println();
        }
    }
}
