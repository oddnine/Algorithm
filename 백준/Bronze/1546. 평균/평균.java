import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] tempString = br.readLine().split(" ");
        List<Double> scores = new ArrayList<>();

        for (int i = 0; i < tempString.length; i++) {
            scores.add(Double.parseDouble(tempString[i]));
        }

        Double max = Collections.max(scores);

        for (int i = 0; i < scores.size(); i++) {
            scores.set(i, scores.get(i).doubleValue() / max * 100);
        }

        Double total = 0.0;
        for (int i = 0; i < scores.size(); i++) {
            total+=scores.get(i);
        }

        bw.write(String.valueOf(total/count));

        bw.flush();
        bw.close();
    }
}