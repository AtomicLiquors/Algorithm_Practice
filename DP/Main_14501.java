package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N];
        int[] prices = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[N];
        DP[N-1] = times[N-1] == 1 ? prices[N-1] : 0;

        for (int i = N-2; i >= 0; i--){
            int j = i + times[i];
            int prev = DP[i+1];
            int curr = 0;
            if(j <= N)
                curr = prices[i] + (j < N ? DP[j] : 0 );
            DP[i] = Math.max(curr, prev);
        }

        System.out.println(DP[0]);
    }
}
