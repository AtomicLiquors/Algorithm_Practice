package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT_11002_failed {

    static boolean[] cache;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cache =  new boolean[1 << M];
        cache[0] = true;

        int[] CPTIs = new int[N];

        int answer = 0;
        for (int i = 0; i < N; i++) {
            CPTIs[i] = Integer.parseInt(br.readLine(), 2);
        }

        subset(0, 0);

        for (int left = 0; left < N; left++) {
            for (int right = left+1; right < N; right++) {
                int numLeft = CPTIs[left];
                int numRight = CPTIs[right];
                if( cache[numLeft ^ numRight] )
                    answer++;
            }
        }

        System.out.println(answer);
    }

    static void subset(int num, int cnt){
        if(cnt == 2){
            cache[num] = true;
            return;
        }


        for (int i = 0; i < M; i++) {
            subset(num | (1 << i), cnt+1);
        }
    }
}
