package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] tree = new int[N+1][N+1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 1;
            while(st.hasMoreTokens()){
                int curr = Integer.parseInt(st.nextToken());
                tree[i][j] = Math.max(tree[i-1][j-1], tree[i-1][j]) + curr;
                j++;
            }
        }

        int answer = 0;
        for(int target: tree[N]){
            answer = Math.max(target, answer);
        }
        System.out.println(answer);
    }
}
