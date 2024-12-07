package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14502 {

    static int N, M, emptyTiles = -3, answer = 0;
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    static List<int[]> virusList = new ArrayList<>();
    static int map[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 2)
                    virusList.add(new int[]{r, c});
                else if(map[r][c] == 0)
                    emptyTiles++;
            }
        }

        buildWall(0,0);
        System.out.println(answer);
    }

    static void buildWall(int idx, int cnt){
        if(cnt == 3){
            int result = spread();
            answer = Math.max(answer, result);
            return;
        }

        for (int i = idx; i < N * M; i++) {
            int r = i / M; // 행 계산
            int c = i % M; // 열 계산

            if (map[r][c] == 0) { // 빈 칸일 때만 벽 세우기
                map[r][c] = 1;
                buildWall(i + 1, cnt + 1);
                map[r][c] = 0; // 복구
            }
        }
        /* 수정 전 코드
        if(startR >= N){
            startR -= N;
            if(++startC >= M)
                return;
        }

        for (int r = startR; r < N; r++) {
            for (int c = startC; c < M; c++) {
                if(map[r][c] == 0){
                    map[r][c] = 1;
                    buildWall(r + 1, c, cnt + 1);
                    map[r][c] = 0;
                }
            }
        }
         */
    }

    static int spread(){
        int remainingTiles = emptyTiles;
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> que = new ArrayDeque<>();

        for (int i = 0; i < virusList.size(); i++) {
            int startR = virusList.get(i)[0];
            int startC = virusList.get(i)[1];
            que.offer(new int[]{startR, startC});

            while(!que.isEmpty()){
                int[] curr = que.poll();
                int r = curr[0];
                int c = curr[1];

                int nr, nc;
                for (int dir = 0; dir < 4; dir++) {
                    nr = r + dR[dir];
                    nc = c + dC[dir];
                    if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] > 0)
                        continue;

                    visited[nr][nc] = true;
                    remainingTiles--;
                    que.offer(new int[]{nr, nc});
                }
            }
        }

        return remainingTiles;
    }
}
