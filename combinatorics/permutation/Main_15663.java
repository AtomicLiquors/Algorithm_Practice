package combinatorics.permutation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15663 {

    static int N, M, arr[];
    static StringBuilder answerSB = new StringBuilder();
    static Set<String> set = new HashSet<>();
    static boolean isSelected[];
    static int selected[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        isSelected = new boolean[N];
        selected = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i]  = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0);
        System.out.print(answerSB);
        br.close();
    }

    static void perm(int cnt){
        if(cnt == M){
            StringBuilder keySB = new StringBuilder();
            for (int i = 0; i < M; i++) {
                keySB.append(selected[i]).append(' ');
            }
            if(set.add(keySB.toString()))
                answerSB.append(keySB).append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if(isSelected[i])
                continue;
            selected[cnt] = arr[i];
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
