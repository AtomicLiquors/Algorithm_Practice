package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2638 {

    static boolean[][] map;
    static Queue<int[]> melts = new ArrayDeque<>();
    static int N, M;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];

        br.readLine();
        int cheeseCnt = 0;
        for (int i = 1; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            for (int j = 1; j < M-1; j++) {
                map[i][j] = st.nextToken().equals("1");
                if(map[i][j]) {
                    cheeseCnt++;
                }
            }
        }

        int elapsed = 0;
        while(cheeseCnt > 0){
            flood();
            while(!melts.isEmpty()){
                int[] curr = melts.poll();
                map[curr[0]][curr[1]] = false;
                cheeseCnt--;
            }
            elapsed++;
        }

        System.out.println(elapsed);
    }

    static void flood(){

        Queue<int[]> flood = new ArrayDeque<>();
        boolean visited[][] = new boolean[N][M];
        int exposed[][] = new int[N][M];
        flood.offer(new int[]{0, 0});

        while(!flood.isEmpty()){
            int[] curr = flood.poll();
            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = curr[0] + dR[i];
                nc = curr[1] + dC[i];

                if( nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(visited[nr][nc]) continue;

                if(map[nr][nc]){
                    if(++exposed[nr][nc] == 2)
                        melts.offer(new int[]{nr, nc});
                }else{
                    visited[nr][nc] = true;
                    flood.offer(new int[]{nr, nc});
                }
            }

        }
    }
}
