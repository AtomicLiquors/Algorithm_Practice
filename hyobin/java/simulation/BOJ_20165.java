

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20165 {

    static int N, M;
    // 20112KB	184ms
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int score = 0;

        int dR[] = {0, 0, 1, -1};
        int dC[] = {1, -1, 0, 0};

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][M+1];
        boolean[][] fallen = new boolean[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int X, Y, dir, cascade;
        for (int i = 0; i < R; i++) {
            // 공격
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            dir = direct(st.nextToken());

            cascade = 2;
            while(--cascade > 0){
                if(!fallen[X][Y]){
                    if(board[X][Y] > cascade)
                        cascade = board[X][Y];

                    fallen[X][Y] = true;
                    score++;
                }

                X += dR[dir];
                Y += dC[dir];
                if(isOuttaBound(X, Y))
                    break;
            }

            // 수비
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());
            
            if(fallen[X][Y])
                fallen[X][Y] = false;
        }
        br.close();
        
        StringBuilder sb = new StringBuilder();
        sb.append(score).append('\n');
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(fallen[i][j] ? 'F' : 'S').append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static boolean isOuttaBound(int X, int Y){
        return X < 1 || Y < 1 || X > N || Y > M;
    }

    static int direct(String D){
        switch (D){
            case "E":
                return 0;
            case "W":
                return 1;
            case "S":
                return 2;
            case "N":
                return 3;
            default:
                return 0;
        }
    }
}
