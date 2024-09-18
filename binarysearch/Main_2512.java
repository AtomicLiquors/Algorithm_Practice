package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] budgets = new int[N];

        int top = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            top = Math.max(top, budgets[i]);
        }

        int total = Integer.parseInt(br.readLine());

        int answer = 0;

        int bottom = 0;
        while(bottom <= top){
            int threshold = (bottom + top) / 2;

            int sum = 0;
            for (int budget : budgets) {
                sum += Math.min(budget, threshold);
            }
            if(sum > total){
                top = threshold - 1;
            }else{
                answer = Math.max(threshold, answer);
                bottom = threshold + 1;
            }
        }

        System.out.println(answer);
    }
}
