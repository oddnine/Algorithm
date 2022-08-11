import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(bf.readLine());

        int count = 1;
        int start = 1;
        int end = 1;
        int sum = 1;

        while(end!=n){
            if(sum == n){
                count++;
                end++;
                sum+=end;
            } else if(sum>n){
                sum -= start;
                start++;
            } else{
                end++;
                sum+=end;
            }
        }
        System.out.println(count);
    }
}