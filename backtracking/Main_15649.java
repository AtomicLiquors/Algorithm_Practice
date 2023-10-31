package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15649 {

    static int N, M;
    static int[] result;
    static boolean[] selected;


    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    //N과 M(1)
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        result = new int[M];
        selected = new boolean[N+1];

        perm(0);

        bw.write(sb.toString());
        bw.flush();

        br.close();
        bw.close();
    }

    static void perm(int cnt) throws IOException{

        if(cnt==M){
            for (int i = 0; i < M; i++) {
                //sb.append(result[i] + " ");
                sb.append(result[i]).append(" "); //체이닝.
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!selected[i]){
                selected[i] = true;
                result[cnt] = i;
                perm(cnt+1);
                selected[i] = false;
            }
        }
    }

}
