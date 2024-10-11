package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int bottom = 0;
        int top = Integer.MAX_VALUE;

        int[] lans = new int[K];

        for (int i = 0; i < K; i++) {
            lans[i] = Integer.parseInt(br.readLine());
        }

        while(bottom < top){
            long mid = (bottom + top) / 2;

            long cnt = 0;
            for(int lan : lans){
                cnt += (lan / mid);
            }

            if(cnt < N){
                top = (int)mid;
            }else{
                bottom = (int)mid + 1;
            }
        }

        System.out.println(bottom-1);
    }
}
