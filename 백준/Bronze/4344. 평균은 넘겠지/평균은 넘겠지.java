import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());


        for (int i = 0; i < count; i++) {
            String[] temp = br.readLine().split(" ");
            int sC = Integer.parseInt(temp[0]);
            int[] scores = new int[sC];

            for (int j = 1; j < temp.length; j++) {
                scores[j - 1] = Integer.parseInt(temp[j]);
            }

            double avg = Arrays.stream(scores).average().getAsDouble();
            int studentCount = 0;

            for (int j = 0; j < scores.length; j++) {
                if (scores[j] > avg) {
                    studentCount++;
                }
            }

            double per = ((double) studentCount / sC * 100);
            bw.write(String.format("%.3f", per));
            bw.write("%" + "\n");
        }

        bw.flush();
        bw.close();
    }
}