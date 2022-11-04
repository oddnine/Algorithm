import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigDecimal a = sc.nextBigDecimal();
        int b = sc.nextInt();
        System.out.println(a.pow(b).toPlainString());
    }
}