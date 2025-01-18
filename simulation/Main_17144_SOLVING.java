package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_SOLVING {

    static int R, C, T, map[][];
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int[] circulator = new int[2];
        int circulatorIdx = 0;

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int input = Integer.parseInt(st.nextToken());
                if(input != -1){
                    total += map[r][c];
                }else{
                    circulator[circulatorIdx] = r;
                    circulatorIdx++;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            circulateTop(0, 0, circulator[0], C-1);
            circulateBottom(circulator[1], 0, R-1, C-1);
        }

        // 출력 결과가 항상 0인 이유?
        System.out.println(total);
        br.close();
    }

    static boolean isInbound(int r, int c){
        return r < R && c < C && r >= 0 && c >= 0;
    }

    static void spread(){

        int[][] copy = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if(map[r][c] > 0){
                    int rem = map[r][c];
                    int blow = map[r][c] / 5;
                    for (int dir = 0; dir < 4; dir++) {
                        int nr = r + dR[dir];
                        int nc = c + dC[dir];
                        if(isInbound(nr, nc)){
                            copy[nr][nc] += blow;
                            rem -= blow;
                        }else{
                            total -= blow;
                        }
                    }
                    copy[r][c] = rem;
                }
            }
        }

        map = copy;
    }

    static void absorb(int fromR, int fromC, int toR, int toC){
        if(map[toR][toC] <= 0)
            return;

        if(map[fromR][fromC] != -1){
            map[fromR][fromC] = map[toR][toC];
        }else{
            total -= map[toR][toC];
        }

        map[toR][toC] = 0;
    }

    static void circulateTop(int startR, int startC, int endR, int endC){
        if(startR >= endR || startC >= endC)
            return;

        for (int r = endR; r > startR; r--) {
            absorb(r, startC, r-1, startC);
        }

        for(int c = startC; c < endC; c++){
            absorb(startR, c, startR, c+1);
        }

        for(int r = startR; r < endR; r++){
            absorb(r, endC, r+1, endC);
        }

        for(int c = endC; c > startC; c--){
            absorb(endR, c, endR, c-1);
        }

        circulateTop(startR+1, startC + 1, endR - 1, endC - 1);
    }

    static void circulateBottom(int startR, int startC, int endR, int endC){
        if(startR >= endR || startC >= endC)
            return;

        for(int r = startR; r < endR; r++){
            absorb(r, startC, r+1, startC);
        }


        for(int c = startC; c < endC; c++){
            absorb(endR, c, endR, c+1);
        }

        for (int r = endR; r > startR; r--) {
            absorb(r, endC, r-1, endC);
        }

        for(int c = endC; c > startC; c--){
            absorb(startR, c, startR, c-1);
        }

        circulateBottom(startR + 1, startC + 1, endR - 1, endC - 1);
    }
}
