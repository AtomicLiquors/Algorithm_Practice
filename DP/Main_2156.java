package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] DP = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            int wine = Integer.parseInt(br.readLine());
            DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]);
            DP[i][0] = Math.max(DP[i][0], DP[i-1][2]);

            DP[i][1] = DP[i-1][0] + wine;
            DP[i][2] = DP[i-1][1] + wine;
        }

        int answer = Math.max(DP[N][0], DP[N][1]);
        answer = Math.max(answer, DP[N][2]);
        System.out.println(answer);
    }
}
