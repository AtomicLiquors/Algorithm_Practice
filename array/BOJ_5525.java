package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] result = new int[M];
        int answer = 0;

        for (int i = 2; i < M; i++) {
            if (input.charAt(i) == 'I' && input.charAt(i - 1) == 'O' && input.charAt(i - 2) == 'I') {
                result[i] = result[i-2] + 1;
                if(result[i] >= N)
                    answer++;
            }
        }

        System.out.println(answer);
    }
}
