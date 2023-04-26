package combinatorics;

import java.util.Scanner;

public class Main_N과M4 {
    static int N, M, numbers[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[M];

        comb(1, 0);
        System.out.println(sb);
    }

    static void comb(int start, int cnt){
        if(cnt==M){
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            comb(i, cnt+1);
        }
    }
}

