import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num = br.readLine();

        char[] characters = num.toCharArray();

        Arrays.sort(characters);

        for (int i = characters.length-1; i >= 0; i--) {
            System.out.print(characters[i]);
        }
    }
}