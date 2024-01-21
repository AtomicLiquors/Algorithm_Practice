package DP;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] D = new int[N][3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        D[0][0] = Integer.parseInt(st.nextToken());
        D[0][1] = Integer.parseInt(st.nextToken());
        D[0][2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            D[i][0] = Integer.parseInt(st.nextToken()) + Math.min(D[i-1][1], D[i-1][2]);
            D[i][1] = Integer.parseInt(st.nextToken()) + Math.min(D[i-1][0], D[i-1][2]);
            D[i][2] = Integer.parseInt(st.nextToken()) + Math.min(D[i-1][0], D[i-1][1]);
        }

        int last = N-1;
        int answer = Math.min(D[last][0], D[last][1]);
        System.out.println(Math.min(answer, D[last][2]));
    }
}
