package Codeforce.r946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        final int OFFSET = 97;

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            String input =  br.readLine();
            boolean isSelected[] = new boolean[123];
            char[] symmetries = new char[123];
            StringBuilder invertSB = new StringBuilder();

            for(int i = 0; i < input.length(); i++){
                isSelected[input.charAt(i)] = true;
            }
            for (int i = 97; i <= 122; i++) {
                if(isSelected[i])
                    invertSB.append((char)i);
            }
            String inverted = invertSB.toString();

            int S = inverted.length();

            for(int i = 0; i < S; i++){
                symmetries[inverted.charAt(i)] = inverted.charAt(S - i - 1);
            }

            for (int i = 0; i < N; i++) {
                sb.append(symmetries[input.charAt(i)]);
            }


            sb.append('\n');
        }
        System.out.print(sb);

    }
}
