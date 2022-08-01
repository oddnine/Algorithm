import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger a = BigInteger.valueOf(scanner.nextLong());
        BigInteger b = BigInteger.valueOf(scanner.nextLong());
        BigInteger c = BigInteger.valueOf(scanner.nextLong());

        System.out.println(a.add(b.add(c)));
        return;
    }
}