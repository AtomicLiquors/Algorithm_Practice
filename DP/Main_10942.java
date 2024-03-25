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

            for(int L = i-1, R = i+1; L >= 1 && R < size; L--, R++){
                if(arr[L] == arr[R])
                    DP[L][R] = true;
                else
                    break;
            }

            for(int L = i-1, R = i; L >= 1 && R < size; L--, R++){
                if(arr[L] == arr[R])
                    DP[L][R] = true;
                else
                    break;
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(DP[left][right] ? 1 : 0).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
