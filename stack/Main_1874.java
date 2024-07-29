package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();

        st.push(0);
        int prev = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            if(st.peek() == target){
                st.pop();
                sb.append('-').append('\n');
            }else if(st.peek() < target){
                while(prev < target){
                    st.push(++prev);
                    sb.append('+').append('\n');
                }
                st.pop();
                sb.append('-').append('\n');
            }else{
                System.out.println("NO");
                return;
            }
        }

        System.out.print(sb);
    }
}
