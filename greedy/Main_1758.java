package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main_1758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] tips = new Integer[N];
        for (int i = 0; i < N; i++) {
           tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips, Collections.reverseOrder());

        long answer = 0;
        for (int i = 0; i < N; i++) {
           answer += Math.max(tips[i] - i, 0);
        }

        System.out.println(answer);
    }
}
