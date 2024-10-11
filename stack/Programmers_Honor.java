package stack;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_Honor {

    public static void main(String[] args) {

        int k = 3;
        int[] score = new int[]{10,100,20,150,1,100,200};
        int[] answer = new int[score.length];

        Stack<Integer> honor = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for(int i = 0; i < score.length; i++){
            while(!honor.isEmpty() && honor.peek() < score[i]){
                temp.push(honor.pop());
            }
            if(honor.size() < k)
                honor.push(score[i]);

            while(honor.size() < k && !temp.isEmpty()){
                honor.push(temp.pop());
            }

            answer[i] = honor.peek();
            temp.clear();
        }

        System.out.println(Arrays.toString(answer));
    }

}
