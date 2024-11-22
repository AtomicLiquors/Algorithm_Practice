package combinatorics.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_27470 {

    static int N, arr[], answer[];
    static boolean found;

    public static void main(String[] args) throws IOException {
        // 10%까지 정답.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[N];
        answer = new int[N/2];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        comb(0, 0, 0);

        StringBuilder sb = new StringBuilder();
        if(found){
            sb.append("YES").append('\n');
            for (int e : answer){
                sb.append(e).append(' ');
            }
        }else{
            sb.append("NO");
        }
        System.out.println(sb);
    }

    static void comb(int start, int cnt, int GDC){

        if(cnt == answer.length){
            found = true;
            return;
        }

        for (int i = start; i < N; i++) {
            int nextGDC = cnt > 0 ? getGDC(GDC, arr[i]) : arr[i];
            if(found || nextGDC == 1)
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
