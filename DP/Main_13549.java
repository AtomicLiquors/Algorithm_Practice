package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_13549 {
    public static void main(String[] args) throws IOException {
        // 더 빠른 풀이법 : https://www.acmicpc.net/source/86638037

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int INF = 100001;
        int[] DP = new int[INF];
        Arrays.fill(DP, INF);

        for (int i = N; i >= 0; i--) {
            DP[i] = N-i;

            if(i * 2 < INF)
                DP[i * 2] = Math.min(DP[i * 2], DP[i]);
        }

        if(K < N){
            System.out.println(DP[K]);
        }else{
            for (int i = N+1; i < INF-1; i++) {
                DP[i] = Math.min(DP[i], DP[i-1] + 1);
                DP[i] = Math.min(DP[i], DP[i+1] + 1);

                if(i * 2 < INF)
                    DP[i * 2] = DP[i];
            }
            System.out.println(DP[K]);
        }

        br.close();
    }
}
