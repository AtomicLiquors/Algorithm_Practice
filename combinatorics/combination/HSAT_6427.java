package combinatorics.combination;

import java.io.*;
import java.util.*;

public class HSAT_6427 {
    // 메모리 초과, 틀렸습니다(N이 3보다 작아서 선택이 불가능한 경우)
    // 배열을 조합을 돌릴 때마다 정렬할 게 아니라, 전체 배열을 정렬해 놓고 조합을 돌렸어야.
    static int N, Q, cars[], counts[], selected[] = new int[3];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        cars = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cars[i] = Integer.parseInt(st.nextToken());
            max = Math.max(cars[i], max);
        }
        counts = new int[max + 1];

        comb(0, 0);
        StringBuilder sb = new StringBuilder();
        while(Q-- > 0){
            int target = Integer.parseInt(br.readLine());
            if(N < 3)
                sb.append(0);
            else
                sb.append(target > max ? 0 : counts[target]);
            sb.append('\n');
        }
        System.out.print(sb);

        br.close();
    }

    static void comb(int cnt, int start){
        if(cnt == 3){
            int[] copy = new int[3];
            for(int i = 0; i < 3; i++){
                copy[i] = selected[i];
            }
            Arrays.sort(copy);
            int median = copy[1];
            counts[median]++;
            return;
        }
        for(int i = start; i < N; i++){
            selected[cnt] = cars[i];
            comb(cnt+1, i+1);
        }
    }
}
