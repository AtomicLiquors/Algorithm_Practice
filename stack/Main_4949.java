package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949 {

    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str.equals("."))
                break;

            st = new Stack<>();
            boolean isBalanced = true;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(c == '[' || c == '('){
                    st.push(c);
                }else if(c == ']' || c == ')'){
                    if(!closeBracket(c)) {
                        isBalanced = false;
                        break;
                    }
                }
            }
            if(!st.empty()) isBalanced = false;
            sb.append(isBalanced ? "yes" : "no").append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static boolean closeBracket (char curr){
        if(st.empty())
            return false;
        char prev = st.peek();
        char openingBracket = curr == ']' ? '[' : '(';

        if(prev == openingBracket){
            st.pop();
            return true;
        }

        return false;
    }
}
