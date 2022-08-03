import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        List<Integer> answerList = new ArrayList<>();
        List<Integer> answerList2 = new ArrayList<>(); 
        
        answerList.add(0);
        answerList.add(0);
        answerList.add(0);
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i=0; i<answers.length; i++){
            if(one>=first.length){
                one=0;
            }
            if(two>=second.length){
                two=0;
            }
            if(three>=third.length){
                three=0;
            }
            
            if(first[one]==answers[i]){
                answerList.set(0, answerList.get(0)+1);
            }
            if(second[two]==answers[i]){
                answerList.set(1, answerList.get(1)+1);
            }
            if(third[three]==answers[i]){
                answerList.set(2, answerList.get(2)+1);
            }
            
            one++;
            two++;
            three++;
        }
        
        int max = Collections.max(answerList);
        
        for(int i=0; i < answerList.size(); i++){
            if(max==answerList.get(i)){
                answerList2.add(i+1);
            }
        }
        
        answer = answerList2.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}