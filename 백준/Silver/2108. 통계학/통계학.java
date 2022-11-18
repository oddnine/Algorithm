import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int total = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] arr = new int[n];
        int[] arr2 = new int[8001];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            arr2[arr[i] + 4000]++;
            total += arr[i];

            if(max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]) {
                min = arr[i];
            }
        }

        Arrays.sort(arr);

        int mode_max = 0;
        int mode = 10000;
        boolean flag = false;

        for (int i = min + 4000; i <= max + 4000; i++) {

            if (arr2[i] > 0) {

                if (mode_max < arr2[i]) {
                    mode_max = arr2[i];
                    mode = i - 4000;
                    flag = true;
                }


                else if (mode_max == arr2[i] && flag == true) {
                    mode = i - 4000;
                    flag = false;
                }
            }
        }

        System.out.println(Math.round((float) total / n));
        System.out.println(arr[n / 2]);
        System.out.println(mode);
        System.out.println(max - min);
    }
}