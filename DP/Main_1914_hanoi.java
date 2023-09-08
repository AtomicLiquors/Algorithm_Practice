package DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main_1914_hanoi {

    static int cnt = 0;
    static StringBuilder sb;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] D = new int[N+1];
        D[1] = 1;

        if(N==1){
            System.out.println(D[1]);
            System.out.println("1 3");
            return;
        }

        for (int i = 2; i <= N; i++) {
            D[i] = D[i-1]*2 + 1;
        }
        System.out.println(D[N]);
        hanoi(1,3, 2, N);

    }

    static void hanoi(int start, int end, int mid, int n) throws IOException{
        if(n==1){
            //cnt++;
            sb = new StringBuilder();
            sb.append(start).append(" ").append(end);
            bw.write(sb.toString());
            bw.write("\n");
            bw.flush();
            return;
        }

        hanoi(start,mid, end,n-1);
        hanoi(start,end,mid, 1);
        hanoi(mid,end,start, n-1);
    }
}
