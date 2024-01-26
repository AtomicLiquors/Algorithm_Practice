package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int terms = N-1;
        int[] arr = new int[terms];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < terms; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = Integer.parseInt(st.nextToken());

        long[][] D = new long[terms][21];

        D[0][arr[0]] = 1;

        long prev;
        for (int i = 1; i < terms; i++) {
            for (int j = 0; j <= 20; j++) {
                prev = D[i-1][j];
                if(prev > 0){
                    if(j - arr[i] >= 0 ){
                        D[i][j - arr[i]] += prev;
                    }
                    if( j + arr[i] <= 20)
                        D[i][j + arr[i]] += prev;
                }
            }
        }

        System.out.println(D[terms-1][result]);
    }
}
