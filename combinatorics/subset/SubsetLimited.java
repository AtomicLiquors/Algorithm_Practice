package combinatorics.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubsetLimited {
    // N개 중 M개를 뽑는 코드 - 내가 만든 거라서 검증요.

    static int N, M;
    static boolean[] isSelected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isSelected = new boolean[N];

        subset(0,0);
    }

    static void subset(int cnt, int idx){
        if(idx == N){
            for (int i = 0; i < N; i++) {
                if(isSelected[i]){
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }

        if(cnt < M){
            isSelected[idx] = true;
            subset(cnt+1, idx+1);
            isSelected[idx] = false;
        }
        subset(cnt, idx+1);
    }
}
