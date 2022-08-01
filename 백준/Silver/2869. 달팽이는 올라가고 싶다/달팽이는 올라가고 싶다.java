import java.io.*;

public class Main {
    static public void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] r = bf.readLine().split(" ");

        int a = Integer.parseInt(r[0]); //낮에 올라갈 수 있는 높이
        int b = Integer.parseInt(r[1]); //밤에 떨어지는 높이
        int v = Integer.parseInt(r[2]); //막대 길이

        int current = 1;

        int temp = v - a;

        int n = temp / (a - b);
        if (temp > n*(a-b)) {
            current++;
        }
        bw.write(String.valueOf(n + current));
        bw.close();
    }
}
