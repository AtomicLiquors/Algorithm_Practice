package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        StringBuilder regexSB = new StringBuilder();

        for (int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            regexSB.append(c == '*' ? "(\\w+)?" : c);
        }

        String regex = regexSB.toString();

        StringBuilder answerSB = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            answerSB.append(input.matches(regex) ? "DA" : "NE").append("\n");
        }

        System.out.print(answerSB);
        br.close();
    }
}
