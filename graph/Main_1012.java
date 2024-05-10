package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012 {

    static int N, M, K;
    static boolean[][] map;
    static final int[] dR = {-1, 1, 0, 0};
    static final int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < T; tc++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new boolean[N][M];

            int r, c;
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                r = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                map[r][c] = true;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j]){
                        answer++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void dfs(int r, int c){
        map[r][c] = false;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];

            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;

            if(map[nr][nc])
                dfs(nr, nc);
        }
    }
}
