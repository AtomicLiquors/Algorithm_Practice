package DP.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int end = C * 100 + 1;
        // 최악의 가성비 : 100원 들여서 1명. -> 메모리 초과

        int[][] D = new int[N+1][end];
        int[] costs = new int[N+1];
        int[] profits = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int idx = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < end; j++) {
                if(j < costs[i])
                    D[i][j] = D[i-1][j];
                else
                    D[i][j] = Math.max(D[i-1][j], D[i][j - costs[i]] + profits[i]);

                if(D[i][j] >= C){
                    idx = Math.min(idx, j);
                    break;
                }
            }
        }

        System.out.println(idx);
    }
}
