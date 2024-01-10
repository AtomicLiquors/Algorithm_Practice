package src.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        int[] D = new int[K+1];
        D[0] = 1;

        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= N; i++){
            for (int j = coins[i]; j <= K; j++) {
                D[j] += D[j - coins[i]];
            }
        }

        System.out.println(D[K]);
    }
}
