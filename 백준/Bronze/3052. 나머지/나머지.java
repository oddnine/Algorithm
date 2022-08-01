import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> n = new ArrayList<>();
        List<Integer> n2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            n.add(Integer.parseInt(br.readLine()) % 42);
        }

        for (int i = 0; i < n.size(); i++) {
            if (n2.isEmpty() || !n2.contains(n.get(i))){
                n2.add(n.get(i));
            }
        }

        bw.write(String.valueOf(n2.size()));

        bw.flush();
        bw.close();
    }
}