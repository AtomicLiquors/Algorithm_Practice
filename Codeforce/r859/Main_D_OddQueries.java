package Codeforce.r859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D_OddQueries {
    //Main_D_OddQueries
    //시간 초과.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());

            int[] remainders = new int[N+1];
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                remainders[i] = Integer.parseInt(st.nextToken()) % 2;
                sum += remainders[i];
            }

            sum %= 2;

            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken()) % 2;

                int subSum = 0;
                int curr;
                for (int i = L; i <= R; i++) {
                    subSum += (K + remainders[i])%2;
                }

                subSum += sum;
                subSum %= 2;

                System.out.println(subSum==1? "YES": "NO");
            }
        }

    }
}
