import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[26];

        int count = in.nextInt();
        ArrayList<String> strArr = new ArrayList<>();

        for (int i = 0; i < count + 1; i++) {
            strArr.add(in.nextLine());
        }
        int temp = 0;

        for (int i = 0; i < strArr.size(); i++) {
            for (int j = 0; j < strArr.get(i).length(); j++) {
                if (arr[strArr.get(i).charAt(j) - 'a'] == 0) {
                    arr[strArr.get(i).charAt(j) - 'a']++;
                    if (j == strArr.get(i).length() - 1) {
                        temp++;
                    }
                    continue;
                } else if (j > 0 && strArr.get(i).charAt(j) == strArr.get(i).charAt(j - 1)) {
                    arr[strArr.get(i).charAt(j) - 'a']++;
                    if (j == strArr.get(i).length() - 1) {
                        temp++;
                    }
                    continue;
                } else {
                    break;
                }
            }
            arr = new int[26];
        }

        System.out.println(temp);
    }
}