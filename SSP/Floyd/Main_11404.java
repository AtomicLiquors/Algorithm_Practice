package SSP.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int MAX = 100_001 * 99;
        // 최댓값 설정 : 최대 비용은 편도 버스 거리가 아니라 편도 버스 거리(100000+) * 최대 정점 갯수(99)여야 한다.

        int[][] DP = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(DP[i], MAX);
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            DP[start][end] = Math.min(cost, DP[start][end]);
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == k)
                    continue;
                for (int j = 1; j <= N; j++) {
                    if (i == j || j == k)
                        continue;

                    DP[i][j] = Math.min(DP[i][j], DP[i][k] + DP[k][j]);

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(DP[i][j] == MAX ? 0 : DP[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
