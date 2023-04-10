package DP;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_조합_BigInteger {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        BigInteger [][] D = new BigInteger[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i<j) continue;
                if(i==j || i==0 || j==0){
                    D[i][j] = D[i][i-j] = BigInteger.valueOf(1);
                }else if(j==1){
                    D[i][j] = D[i][i-j] = BigInteger.valueOf(i);
                }else{
                    D[i][j] = D[i][i-j] =
                            D[i-1][j].add(D[i-1][j-1]);
                }
            }
        }


        System.out.println(D[n][m]);
    }
}
