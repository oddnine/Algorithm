class Solution {
    int[][] coms;
    static boolean[] check;
    int n;
    
    public boolean[] dfs(int x){
        check[x] = true;

        for (int i = 0; i < n; i++) {
            if (i != x && coms[x][i] == 1 && !check[i]) {
                check = dfs(i);
            }
        }

        return check;
    }
    
    public int solution(int temp, int[][] computers) {
        int answer = 0;
        n = temp;
        check = new boolean[n];
        coms = computers;

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(i);
                answer++;
            }
        }

        return answer;
    }
}