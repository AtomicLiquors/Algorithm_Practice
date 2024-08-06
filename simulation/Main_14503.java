package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        int answer = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[][] isWall = new boolean[N][M];
        boolean[][] isClean= new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                isWall[i][j] = Integer.parseInt(st.nextToken()) == 1;
        }

        while(true){
            if(!isClean[r][c]){
                isClean[r][c] = true;
                answer++;
            }

            boolean isProceeding = false;
            int nr, nc, nd;
            for (int dir = 3; dir >= 0; dir--) {
                nd = (d + dir) % 4;
                nr = r + dR[nd];
                nc = c + dC[nd];
                if(!isWall[nr][nc] && !isClean[nr][nc]){
                   r = nr;
                   c = nc;
                   d = nd;
                   isProceeding = true;
                   break;
                }
            }

            if(!isProceeding){
                nd = (d + 2) % 4;
                nr = r + dR[nd];
                nc = c + dC[nd];
                if(isWall[nr][nc])
                    break;
                else {
                    r = nr;
                    c = nc;
                }
            }
        }

        System.out.println(answer);
    }
}
