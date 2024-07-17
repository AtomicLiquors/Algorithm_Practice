package Mathematics.ExpressionParsing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_1935 {

    static int idx;
    static String expression;
    static  Map<Character, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        expression = br.readLine();
        idx = expression.length()-1;
        map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put((char) (i + 65), Integer.parseInt(br.readLine()));
        }
        System.out.println(
            String.format("%.2f", calculate())
        );
    }
    static double calculate() throws Exception {
        char next = expression.charAt(idx);
        char operator = next;

        next = expression.charAt(--idx);
        double b;
        if(isAlphabet(next))
            b = map.get(next);
        else
            b = calculate();

        next = expression.charAt(--idx);
        double a;
        if(isAlphabet(next))
            a = map.get(next);
        else
            a = calculate();

        return operate(operator, a, b);
    }

    static double operate(char operator, double a, double b) throws Exception{
        switch (operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                throw new Exception();
        }
    }

    static boolean isAlphabet(char c){
        return c >= 65 && c <= 90;
    }
}
