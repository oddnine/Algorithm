import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Candidate implements Comparable<Candidate> {
    String name;
    int count;
    Boolean check;

    Candidate(String name, int count) {
        this.name = name;
        this.count = count;
        this.check = false;
    }

    public void setCheck() {
        check = true;
    }

    @Override
    public int compareTo(Candidate c) {
        return (this.count > c.count) ? 1 : -1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Candidate> candidates = new ArrayList<>();
        Queue<Integer>[] votes = new LinkedList[1001];
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            candidates.add(new Candidate(br.readLine(), 0));
        }

        String vote;
        int voteCount = 0;

        while ((vote = br.readLine()) != null && vote.length() != 0) {
            String[] split = vote.split(" ");
            votes[voteCount] = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                votes[voteCount].add(Integer.parseInt(split[i]) - 1);
            }
            voteCount++;
        }

        while (true) {
            List<String> names = new ArrayList<>();
            int minCount = 9999;
            int maxCount = 0;

            for (int i = 0; i < voteCount; i++) {
                while (candidates.get(votes[i].peek()).check) {
                    votes[i].poll();
                }
                candidates.get(votes[i].peek()).count++;
            }

            for (int i = 0; i < n; i++) {
                maxCount = Math.max(maxCount, candidates.get(i).count);
                if (!candidates.get(i).check) {
                    minCount = Math.min(minCount, candidates.get(i).count);
                }
            }

            for (int i = 0; i < candidates.size(); i++) {
                if ((double) candidates.get(i).count / voteCount > 0.5 || minCount == maxCount) {
                    if (candidates.get(i).count == maxCount) {
                        names.add(candidates.get(i).name);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (candidates.get(i).count == minCount) {
                    candidates.get(i).setCheck();
                } else if (!candidates.get(i).check) {
                    candidates.get(i).count = 0;
                }
            }

            if (names.size() > 0) {
                for (String name : names) {
                    System.out.println(name);
                }
                return;
            }
        }
    }
}