package combinatorics.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27470 {

    static int N, arr[], answer[];
    static boolean found;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        // 플래티넘 5 랭크.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        answer = new int[N/2 + N%2];
        // 1차 수정 : 버림이 아닌 올림.

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sb = new StringBuilder();
        comb(0, 0, -1);

        if(!found)
            sb.append("NO");

        System.out.println(sb);
    }

    static void comb(int start, int cnt, int GDC){

        if(cnt == answer.length){
            found = true;
            sb.append("YES").append('\n');
            for (int e : answer){
                sb.append(e).append(' ');
            }
            return;
        }

        for (int i = start; i < N; i++) {
            if(found)
                continue;
            int nextGDC = cnt > 0 ? getGDC(GDC, arr[i]) : arr[i];
            if(nextGDC == 1)
                continue;
            answer[cnt] = arr[i];
            comb(i+1, cnt+1, nextGDC);
        }
    }

    static int getGDC(int a, int b){
        if(b == 0)
            return a;
        return getGDC(b, a % b);
    }
}
