package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10974 {

    static int N;
    static boolean[] selected;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        selected = new boolean[N+1];
        numbers = new int[N];

        perm(0);

        System.out.print(sb);
    }

    static void perm(int cnt){
        if(cnt == N){
            for (int i = 0; i < N; i++) {
               sb.append(numbers[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {

            numbers[cnt] = i;
            perm(cnt+1);
        }
    }
}
