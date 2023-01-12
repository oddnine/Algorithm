import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int b = 0;

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
                b = num;
            } else if (a.equals("pop")) {
                Integer poll = q.poll();
                if (poll == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(poll);
                }
            } else if (a.equals("size")) {
                System.out.println(q.size());
            } else if (a.equals("empty")) {
                int size = q.size();
                if (size == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (a.equals("front")) {
                Integer peek = q.peek();
                if (peek == null) {
                    System.out.println(-1);
                } else {
                    System.out.println(peek);
                }
            } else if (a.equals("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(b);
                }
            }
        }
    }
}
