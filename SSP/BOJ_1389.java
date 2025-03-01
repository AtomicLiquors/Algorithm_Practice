package SSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1389 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        final int MAX = N;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = MAX;
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            dist[from][to] = dist[to][from] = 1;
        }

        for (int mid = 1; mid <= N; mid++) {
            for (int start = 1; start <= N; start++) {
                if(start == mid)
                    continue;
                for (int end = 1; end <= N; end++) {
                    if(start == end || mid == end)
                        continue;

                    dist[start][end] =
                            Math.min(dist[start][mid] + dist[mid][end], dist[start][end]);
                }
            }
        }

        int[] bacon = new int[N+1];
        int min = Integer.MAX_VALUE;
        int answer = -1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(i != j)
                    bacon[i] += dist[i][j];
            }

            if(min > bacon[i]){
                min = bacon[i];
                answer = i;
            }
        }

        System.out.println(answer);
    }
}
