package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)) ;
        int N = Integer.parseInt(br.readLine());
        int[] DP = new int[N+1];

        DP[0] = DP[1] = 1;

        for (int i = 2; i <= N; i++) {
            DP[i] = (DP[i-1] + 2 * DP[i-2]) % 10007;
        }

        System.out.println(DP[N]);
    }
}
