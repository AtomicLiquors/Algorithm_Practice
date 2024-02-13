package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21922 {
    static int N, M, answer, map[][], affected[][];
    static int[] dR = {-1, 0, 1, 0}; // 상 좌 하 우 0 1 2 3
    static int[] dC = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<int[]> fans = new ArrayDeque<>();

        map = new int[N][M];
        affected = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    fans.offer(new int[]{i, j});
                    map[i][j] = 0;
                }
            }
        }

        answer = 0;

        while(!fans.isEmpty()){
            int[] curr = fans.poll();

            for (int dir = 0; dir < 4; dir++) {
                cool(curr[0], curr[1], dir);
            }
        }

        System.out.println(answer);
    }



    static void cool(int r, int c, int dir){
        while(isCoolable(r, c, dir)){
            if(affected[r][c] == 0) answer++;
            markCoolingDirection(r, c, dir);

            if(map[r][c] > 0 && reflect(r, c, dir, map[r][c])) break;

            r += dR[dir];
            c += dC[dir];
        }
    }

    static void markCoolingDirection(int r, int c, int dir){
        affected[r][c] = affected[r][c] | (1 << dir);
    }

    static boolean isCoolable(int r, int c, int dir){
        return r >= 0 && c >= 0 && r < N && c < M && (affected[r][c] & (1<<dir) ) == 0;
    }

    static boolean reflect(int r, int c, int dir, int type){
        int nd;
        switch (type){
            case 1:
                if(dir % 2 == 1){
                    nd = (dir + 2) % 4;
                    cool(r + dR[nd], c + dC[nd], nd);
                    return true;
                }
                break;
            case 2:
                if(dir % 2 == 0){
                    nd = (dir + 2) % 4;
                    cool(r + dR[nd], c + dC[nd], nd);
                    return true;
                }
                break;
            case 3:
                // 하 <-> 좌, 상 <-> 우
                // 1 <-> 2 0 <-> 3
                nd = 3 - dir;
                cool(r + dR[nd], c + dC[nd], nd);
                return true;
            case 4:
                if(dir % 2 == 1)
                    nd = dir - 1;
                else
                    nd = dir + 1;
                    // 하 <-> 우, 상 <-> 좌
                cool(r + dR[nd], c + dC[nd], nd);
                return true;
        }
        return false;
    }
}
