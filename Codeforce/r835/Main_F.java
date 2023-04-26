package Codeforce.r835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            int d = Integer.parseInt(st.nextToken());


            Integer[] rewards = new Integer[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                rewards[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rewards, Collections.reverseOrder());

            if(rewards[0] > c){
                System.out.println("Infinity");
            }else if(rewards[0] * d < c){
                System.out.println("Impossible");
            }else{
                int k = -1;
                long sum = Long.MAX_VALUE;
                while(sum > c){
                    k++;
                    int div = k+2;
                    sum=0;
                    for (int idx = 0; idx < d; idx++) {
                        if(idx%div < n) sum += rewards[idx%div];
                    }
                }
                System.out.println(k);

            }

        }


    }
}
