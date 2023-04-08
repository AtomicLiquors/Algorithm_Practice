package DP;

import java.util.Scanner;

public class Main_fibonacci3 {

    static int cnt0 = 0;
    static int cnt1 = 1;

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {
            cnt0 = cnt1 = 0;
            int n = sc.nextInt();
            if (n == 0) {
                System.out.println("1 0");
            } else if (n == 1) {
                System.out.println("0 1");
            }else{
                int[] D = new int[n + 1];
                D[0] = 0;
                D[1] = 1;
                for (int i = 2; i <= n; i++) {
                    D[i] = D[i - 1] + D[i - 2];
                }

                System.out.println(D[n - 1] + " " + D[n]);
            }

        }

    }

}
