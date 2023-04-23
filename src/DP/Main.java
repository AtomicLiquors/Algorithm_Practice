package DP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] D = new int[11];
        D[1] = 1;
        for (int i = 1; i < 10; i++) {
            D[i+1] = i + D[i];
        }
        for (int i = 0; i < T; i++) {
            sb.append(D[sc.nextInt()]).append("\n");
        }
        System.out.println(sb);
    }
}
