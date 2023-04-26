package DP;

import java.util.Scanner;

public class Main_2nTiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] D = new long[Math.max(n+1, 3)];


        D[1] = 1;
        D[2] = 2;


        if(n<=2){
            System.out.println(D[n]);
            return;
        }


        for (int i = 3; i <= n; i++) {
            D[i] = (D[i-1] + D[i-2])%10007;
        }

        System.out.println(D[n]);
    }
}
