import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] zeroToTen = new int[10];
        int total = 1;

        for (int i = 0; i < 3; i++) {
            total *= Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < String.valueOf(total).length(); i++) {
            String temp = Integer.toString(total);
            zeroToTen[Character.getNumericValue(temp.charAt(i))]++;
        }

        for (int i = 0; i < zeroToTen.length; i++) {
            bw.write(String.valueOf(zeroToTen[i]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}