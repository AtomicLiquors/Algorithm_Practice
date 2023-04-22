package DP;

import java.util.Scanner;

public class Main_123더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] D = new int[11];
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4; i < 11; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }
        for (int i = 0; i < T; i++) {
            sb.append(D[sc.nextInt()]).append("\n");
        }

        System.out.println(sb);
    }

}
