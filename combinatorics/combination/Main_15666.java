package combinatorics.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15666 {

    static int N, M, arr[], selected[];
    static StringBuilder keySB = new StringBuilder();
    static StringBuilder answerSB = new StringBuilder();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        selected = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);


        comb(0,0);

        System.out.print(answerSB);

        br.close();
    }

    static void comb(int start, int cnt){
        if(cnt == M){
            keySB = new StringBuilder();
            for (int i = 0; i < M; i++) {
                keySB.append(selected[i]).append(' ');
            }

            String key = keySB.toString();
            if(set.add(key))
                answerSB.append(key).append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            selected[cnt] = arr[i];
            comb(i, cnt+1) ;
        }
    }
}
