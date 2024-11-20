package combinatorics.subset.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubsetLimited {
    // N개 중 M개를 뽑는 코드 - 내가 만든 거라서 검증요.
    // cnt가 0이 나오는 경우가 있다. (단 하나도 뽑지 않는 경우) 이건 원래 subset에서도 동일한가? 뭐 부분집합이라니 공집합도 있겠지.

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
