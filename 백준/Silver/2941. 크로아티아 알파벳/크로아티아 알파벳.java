import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static public void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        List<String> croatiaArray = new ArrayList<>();
        croatiaArray.add("c=");
        croatiaArray.add("c-");
        croatiaArray.add("dz=");
        croatiaArray.add("d-");
        croatiaArray.add("lj");
        croatiaArray.add("nj");
        croatiaArray.add("s=");
        croatiaArray.add("z=");

        String croatia = scanner.nextLine();
        int check = 0;

        char[] chs = croatia.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length; i++) {
            for (String ca : croatiaArray
            ) {
                check = 0;
                char[] tempChar = {};
                char[] tempChar2 = {};

                if (chs.length > i + 1) {
                    tempChar = new char[]{chs[i], chs[i + 1]};
                }
                if (chs.length > i + 1 && chs.length > i + 2) {
                    tempChar2 = new char[]{chs[i], chs[i + 1], chs[i + 2]};
                }

                if (String.valueOf(tempChar).equals(ca)) {
                    count++;
                    i++;
                    check = 1;
                    break;
                } else if (String.valueOf(tempChar2).equals(ca)) {
                    count++;
                    i = i + 2;
                    check = 1;
                    break;
                }

            }
            if(check == 0){
                count++;
            }
        }

        System.out.println(count);
    }
}
