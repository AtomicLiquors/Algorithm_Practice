package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            int left = 0;
            int right = N;

            while(left < right){
                int mid = (left + right) / 2;

                if(target > cards[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            int start = left;

            left = 0;
            right = N;

            while(left < right){
                int mid = (left + right) / 2;

                if(target >= cards[mid]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }

            int end = left;


            sb.append(end - start).append(' ');
        }

        System.out.println(sb);
    }
}
