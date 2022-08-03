import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0; i<commands.length; i++){
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            list2.add(list.get(commands[i][2]-1));
            list = new ArrayList<>();
        }
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list2.get(i);
        }
        
        return answer;
    }
}