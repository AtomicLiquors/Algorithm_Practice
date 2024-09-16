package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int left = 0;
        int right = N * N;

        while(left < right){
            int mid = (left + right) / 2;

            int cnt = 0;
            for(int i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N);
            }

            if(cnt >= K){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
