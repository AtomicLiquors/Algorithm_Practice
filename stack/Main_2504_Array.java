package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_2504_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        Stack<Character> st = new Stack<>();
        int[] sums = new int[N];
        int idx = -1;
        int answer = 0;

        for (int i = 0; i < N; i++) {
           char curr = input.charAt(i);

           if(curr == '(' || curr == '['){
               st.push(curr);
               sums[++idx] = 0;
           }else{
               if(st.isEmpty() || !isPair(st.peek(), curr)){
                   System.out.println(0);
                   return;
               }else{
                   st.pop();
                   int total = sums[idx];
                   int result = (total == 0 ? 1 : total) * getMult(curr);
                   if(--idx >= 0){
                       sums[idx] = sums[idx] + result;
                   }else{
                       answer += result;
                   }
               }
           }

        }

        System.out.println(st.isEmpty() ? answer : 0);
    }

    static int getMult(char close){
        return close == ']' ? 3 : 2;
    }

    static boolean isPair(char open, char close){
        if( (open == '(' && close == ')') || (open == '[' && close == ']') )
            return true;
        else
            return false;
    }
}
