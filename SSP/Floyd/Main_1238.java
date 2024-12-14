package SSP.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 100 * 10000 + 1;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            dist[from][to] = weight;
        }

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from <= N; from++) {
                if(k == from)
                    continue;
                for (int to = 1; to <= N; to++) {
                    if(k == from || to == from)
                        continue;
                    dist[from][to] = Math.min(dist[from][k] + dist[k][to], dist[from][to]);
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            answer = Math.max(answer, dist[i][X] + dist[X][i]);
        }
        System.out.println(answer);
    }
}
