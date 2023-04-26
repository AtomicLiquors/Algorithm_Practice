package DP;

import java.util.Scanner;

public class Main_2775_부녀회장이될거야 {
    static int[][] map;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int K = sc.nextInt();
            int N = sc.nextInt();

            int size = Math.max(K, N)+1;
            map = new int[size][size];

            System.out.println(dp(K,N));
        }
    }

    static int dp(int k, int n){
        if(n==0) return 0;
        else if(k==0) return n;
        else if(map[k][n]==0){
            map[k][n] = dp(k-1, n) + dp(k, n-1);
        }
        return map[k][n];
    }
}
