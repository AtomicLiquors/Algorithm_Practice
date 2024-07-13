package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_18427 {
    //12680KB 136ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] DP = new int[N+1][H+1];
        ArrayList<Integer>[] blocks = new ArrayList[N+1];
        int[] blockCount = new int[N+1];

        DP[0][0] = 1;

        for (int i = 1; i <= N; i++) {
            blocks[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                blocks[i].add(Integer.parseInt(st.nextToken()));
                blockCount[i]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= H; j++) {
               DP[i][j] = DP[i-1][j];
                for (int b = 0; b < blockCount[i]; b++) {
                int block = blocks[i].get(b);
                if(j >= block)
                   DP[i][j] = ( DP[i][j] + DP[i-1][j - block] ) % 10007;
                }
            }
        }

        System.out.println(DP[N][H]);

        br.close();
    }
}
