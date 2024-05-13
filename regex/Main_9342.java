package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            String str = br.readLine();
            boolean result = str.matches("[A-F]?A*F*C*[A-F]?");

            sb.append(result ? "Infected!" : "Good").append('\n');
        }

        System.out.println(sb);
    }
}
