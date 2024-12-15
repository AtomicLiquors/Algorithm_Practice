package combinatorics.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15666 {

    static int N, M, arr[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        comb(0,0);


        System.out.print(sb);
        br.close();
    }

    static void comb(int start, int cnt){
        if(cnt == M){
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            sb.append(arr[i]).append(' ');
            comb(i, cnt+1) ;
        }
    }

    static void reversalComb(){

    }
}
