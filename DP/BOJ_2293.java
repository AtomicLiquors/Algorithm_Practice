
import java.io.BufferedReader;
// 동전 1

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N+1];
        int[][] D = new int[N+1][K+1];
        // 동적 테이블을 1차원 배열로 하고도 푸는 방법이 있다. how?

        for (int i = 1; i <= N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
            D[i][0] = 1;
        }

        for(int i = 1; i <= N; i++){
            for (int j = 1; j <= K; j++) {
                D[i][j] = D[i-1][j] + ( j >= coins[i]? D[i][j - coins[i]] : 0 );
            }
        }

        System.out.println(D[N][K]);
    }
}
