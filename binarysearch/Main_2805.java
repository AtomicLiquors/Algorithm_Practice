package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] trees = new long[N+1];
        long[] prefix = new long[N+1];

        for (int i = 1; i <= N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i-1] + trees[i];
        }

        long bottom = 0;
        long top = trees[N];
        long answer = -1;
        long mid;

        while(bottom <= top){
            mid = (bottom + top) / 2;
            int key = Arrays.binarySearch(trees, mid);

            if(key < 0)
                key = -key - 2;

            long result = (prefix[N] - prefix[key]) - mid * (N - key);

            if(result >= M){
                bottom = mid + 1;
                answer = mid;
            }else{
                top = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
