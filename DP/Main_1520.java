package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520 {

    static int N, M, map[][], result[][];
    static boolean visited[][];

    static int[] dR = {0, 1, 0, -1};
    static int[] dC = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        result = new int[M][N];
        visited = new boolean[M][N];
        result[M-1][N-1] = 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(track(0,0));
    }

    static int track(int r, int c){
        if(visited[r][c])
            return result[r][c];

        int value = 0;
        int nr, nc;
        for(int i = 0; i < 4; i++){
            nr = dR[i] + r;
            nc = dC[i] + c;

            if(nr < 0 || nc < 0 || nr >= M || nc >= N)
                continue;

            if(map[r][c] > map[nr][nc]){
                if(result[nr][nc] == 0)
                    track(nr, nc);
                value += result[nr][nc];
            }
        }
        visited[r][c] = true;
        return result[r][c] = value;
    }
}
