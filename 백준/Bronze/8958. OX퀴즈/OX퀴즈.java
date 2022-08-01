import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        int total = 0;

        int c = 0;

        for (int i = 0; i < count; i++) {
            String ox = br.readLine();
            for (int j = 0; j < ox.length(); j++) {
                if (total == 0) {
                    if (ox.charAt(j) == 'O') {
                        total += 1;
                        c += 1;
                    }
                } else if (ox.charAt(j) == 'O') {
                    if (j > 0 && ox.charAt(j - 1) == 'O' || ox.charAt(j) == 'O') {
                        c += 1;
                        total += c;
                    }
                } else if (ox.charAt(j) == 'X') {
                    c = 0;
                }
            }

            bw.write(String.valueOf(total) + "\n");
            total = 0;
            c = 0;
        }


        bw.flush();
        bw.close();
    }
}