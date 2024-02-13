package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2073 {
    static int[][] DP;
    static int[] capacities;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] lengths = new int[P+1];
        capacities = new int[P+1];

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());
            lengths[i] = Integer.parseInt(st.nextToken());
            capacities[i] = Integer.parseInt(st.nextToken());
        }

        DP = new int[P+1][D+1];

        for (int i = 1; i <= P; i++) {
            int prev = i-1;
            DP[i][0] = Integer.MAX_VALUE;

            for (int j = 1; j <= D; j++) {
                int rem = j - lengths[i];
                if(rem >= 0 && DP[prev][rem] > 0)
                    DP[i][j] = Math.max(DP[prev][j], Math.min(capacities[i], DP[i][rem]));
            }
        }

        System.out.println(Arrays.deepToString(DP));
        System.out.println(DP[P][D]);
    }

}
