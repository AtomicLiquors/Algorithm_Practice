package Mathematics.ParseMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char curr = input.charAt(i);

            switch(curr){
                /* 연산자를 만날 때 */
                /* 우선순위가 같거나 작은 것을 전부 스택에서 꺼내준다. */
                /* 현재 연산자를 스택에 넣어준다. */
                case '*': case '/':
                    while(!st.isEmpty() && isHighPriority(st.peek())){
                        sb.append(st.pop());
                    }
                    st.push(curr);
                    break;
                case '+': case '-':
                    while(!st.isEmpty() && st.peek() != '('){
                        sb.append(st.pop());
                    }
                    st.push(curr);
                    break;
                /* 괄호
                * 열린 괄호는 다른 연산자 또는 이전에 열려 있던 괄호보다 항상 높은 우선순위를 갖는다.
                * 그러니 스택에 그냥 넣어준다.
                * */
                case '(':
                    st.push(curr);
                    break;
                    /* 닫힌 괄호를 만나면 열린 괄호를 찾을 때까지 스택의 연산자를 전부 제거한다. */
                case ')':
                    while(true){
                        char prev = st.pop();
                        if(prev == '(')
                            break;
                        sb.append(prev);
                    }
                    break;
                default:
                    sb.append(curr);
            }
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb);

    }

    static boolean isHighPriority(char c){
        return c == '*' || c == '/';
    }
}
