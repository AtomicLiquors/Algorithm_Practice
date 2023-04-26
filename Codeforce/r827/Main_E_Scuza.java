package Codeforce.r827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_E_Scuza {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] stair = new int[N+1];
            long[] sum = new long[N+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                stair[i] = Integer.parseInt(st.nextToken());
                sum[i] = stair[i] + sum[i-1];
            }
            st = new StringTokenizer(br.readLine());
            //long[] result = new long[Q];
            for (int i = 0; i < Q; i++) {
                int k = Integer.parseInt(st.nextToken());
                long answer = 0;
                for (int j = 1; j <= N; j++) {
                    /*System.out.println(k);
                    System.out.println(stair[j]);
                    System.out.println(sum[j]);
                    System.out.println("-==========");*/
                    if(k < stair[j]) break;
                    answer = sum[j];
                }
                System.out.print(answer+" ");
            }
            System.out.println();
        }
    }
}
