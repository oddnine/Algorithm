import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        int total = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        
        Arrays.sort(arr);

        System.out.println(total / arr.length);
        System.out.println(arr[arr.length / 2]);
    }
}