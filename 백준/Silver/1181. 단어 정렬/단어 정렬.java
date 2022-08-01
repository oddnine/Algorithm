import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] words = new String[count];

        for (int i = 0; i < count; i++) {
            words[i] = br.readLine();
        }

        Arrays.sort(words);
        Arrays.sort(words, Comparator.comparing(String::length));
        String[] words2 = Arrays.stream(words).distinct().toArray(String[]::new);

        for (int i = 0; i < words2.length; i++) {
            System.out.println(words2[i]);
        }
    }
}