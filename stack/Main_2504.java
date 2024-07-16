package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length();

        Stack<Character> st = new Stack<>();
        List<Integer> sums = new ArrayList<>();
        int idx = -1;
        int answer = 0;

        for (int i = 0; i < N; i++) {
           char curr = input.charAt(i);

           if(curr == '(' || curr == '['){
               st.push(curr);
               sums.add(0);
               idx++;
           }else{
               if(st.isEmpty() || !isPair(st.peek(), curr)){
                   System.out.println(0);
                   return;
               }else{
                   st.pop();
                   int total = sums.remove(idx);
                   int result = (total == 0 ? 1 : total) * getMult(curr);
                   if(--idx >= 0){
                       sums.set(idx, sums.get(idx) + result);
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
        if(open == '(' && close == ')')
            return true;
        else if(open == '[' && close == ']')
            return true;
        else
            return false;
    }
}
