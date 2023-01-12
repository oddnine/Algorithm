import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            if (a.equals("push_front")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (a.equals("push_back")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addLast(num);
            } else if (a.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer poll = deque.pollFirst();
                    System.out.println(poll);
                }
            } else if (a.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer poll = deque.pollLast();
                    System.out.println(poll);
                }
            } else if (a.equals("size")) {
                System.out.println(deque.size());
            } else if (a.equals("empty")) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (a.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer peek = deque.peekFirst();
                    System.out.println(peek);
                }
            } else if (a.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    Integer peek = deque.peekLast();
                    System.out.println(peek);
                }
            }
        }
    }
}
