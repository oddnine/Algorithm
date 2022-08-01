import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings.add(new Meeting(start, end));
        }

        Collections.sort(meetings, Meeting::compareTo);

        int end = 0;
        int count = 0;

        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).start >= end) {
                end = meetings.get(i).end;
                count++;
            }
        }

        System.out.println(count);

        return;
    }

    public static class Meeting implements Comparable<Meeting> {
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Meeting m) {
            if (this.getEnd() == m.getEnd())
                return this.getStart() - m.getStart();
            return this.getEnd() - m.getEnd();
        }
    }
}