import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t;

        t = sc.nextInt();
        int a, b, r;

        String[] numArr = new String[t];
        for (int i = 0; i < t; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            r = 1;

            for (int j = 0; j < b; j++)
                r = (r * a) % 10;
            if (r == 0) r = 10;
            System.out.println(r);

        }
    }
}