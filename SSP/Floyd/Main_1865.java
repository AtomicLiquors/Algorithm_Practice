package SSP.Floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1865 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            System.out.println(trial() ? "YES" : "NO");
        }

        br.close();
    }

    static boolean trial() throws IOException{
        boolean result = false;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int dist[][] = new int[N+1][N+1];

        final int INF = 10000 * 2500 + 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dist[S][E] = Math.min(dist[S][E], T);
            dist[E][S] = Math.min(dist[E][S], T);
        }

        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            dist[S][E] = Math.min(dist[S][E], -T);
        }


        for (int bridge = 1; bridge <= N; bridge++) {
            for (int from = 1; from <= N; from++) {
                if(bridge == from)
                    continue;
                for (int to = 1; to <= N; to++) {
                    if(bridge == to)
                        continue;
                    dist[from][to] = Math.min(dist[from][to], dist[from][bridge] + dist[bridge][to]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if(dist[i][i] < 0){
                result = true;
                break;
            }
        }

        return result;
    }
}
