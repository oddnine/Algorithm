import java.util.Scanner;

public class Main {
    static public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nums = scanner.nextInt();
        int temp = nums;

        int one;
        int ten;
        int hap;

        int count = 0;
        while (true) {
            one = nums % 10;
            ten = (nums % 100) / 10;
            hap = one + ten;
            if (hap > 9) {
                hap = hap % 10;
            }
            nums = one * 10 + hap;
            count++;
            if (nums == temp) {
                System.out.println(count);
                break;
            }
        }
    }
}