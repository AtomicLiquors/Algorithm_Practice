package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        while(st.hasMoreTokens()){
            que.offer(Integer.parseInt(st.nextToken()));
        }

        int target = 1;
        while(target <= N){
            if(!stack.isEmpty() && stack.peek() == target){
                stack.pop();
            }else{
                while(true){
                    if(que.isEmpty()){
                        System.out.println("Sad");
                        return;
                    }
                    int curr = que.poll();
                    if(curr == target){
                        break;
                    }else{
                        stack.push(curr);
                    }
                }
            }

            target++;
        }
        System.out.println("Nice");
    }
}
