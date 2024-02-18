package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int D = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] lengths = new int[P];
        int[] capacities = new int[P];

        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            lengths[i] = Integer.parseInt(st.nextToken());
            capacities[i] = Integer.parseInt(st.nextToken());
        }

        int[] DP = new int[D+1];
        DP[0] = Integer.MAX_VALUE;

        for (int i = 0; i < P; i++) {
            for (int j = D; j >= lengths[i]; j--) {
                DP[j] = Math.max(DP[j], Math.min(DP[j-lengths[i]], capacities[i]));
            }
        }

        System.out.println(DP[D]);
    }

}
