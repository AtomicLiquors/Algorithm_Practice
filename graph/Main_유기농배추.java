package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_유기농배추 {

    static int[][] map;
    static int M, N, K;
    static int[] dX = {1, 0, 0};
    static int[] dY = {0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt;

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cnt = 0;
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];

            int x, y;
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j]==1){
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y){
        int nx, ny;
        map[x][y] = 2;
        for (int dir = 0; dir < 3; dir++) {
            nx = x + dX[dir];
            ny = y + dY[dir];
            if(nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny]==1)
                dfs(nx, ny);
        }

    }
}
