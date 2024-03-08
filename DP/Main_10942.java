package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942 {

    static int size, arr[];
    static boolean[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine()) + 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[size];
        DP = new boolean[size][size];
        for (int i = 1; i < size; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < size; i++) {
            DP[i][i] = true;
            palindrome(i, i+1);
            palindrome(i-1, i+1);
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(DP[left][right] ? 1 : 0).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

    static void palindrome(int left, int right){
        if(left < 1 || right >= size) return;
        if(arr[left] == arr[right]) {
            DP[left][right] = true;
            palindrome(left-1, right+1);
        }
    }
}
