package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        for (int i = 1; i <= N; i++){
            answer = Math.min(answer, A[i]/i);
        }

        System.out.println(answer);
        br.close();
    }
}
