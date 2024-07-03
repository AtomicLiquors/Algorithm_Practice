package Codeforce.r954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dR = {-1, 1, 0, 0};
        int[] dC = {0, 0, -1, 1};
        // N+1, M+1
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[N][M];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean found = true;
            while(found){
                found = false;
                for (int r = 0; r < N; r++) {
                    for (int c = 0; c < M; c++) {
                        int nr, nc;
                        int max = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            nr = r + dR[dir];
                            nc = c + dC[dir];
                            if(isOuttaBound(nr, nc, N, M))
                                continue;
                            max = Math.max(max, matrix[nr][nc]);
                        }
                        if(matrix[r][c] > max){
                            matrix[r][c] = max;
                            found = true;
                        }
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    sb.append(matrix[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.print(sb);
        }

        br.close();
    }

    static boolean isOuttaBound(int r, int c, int N, int M){
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}
