package graph;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {
    static int[][] map;
    static boolean[][] visited;

    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = -Integer.parseInt(st.nextToken());
                if(map[i][j] == -2) {
                    map[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int nr, nc;
            for (int i = 0; i < 4; i++) {
                nr = curr[0] + dR[i];
                nc = curr[1] + dC[i];
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] > -1) continue;
                map[nr][nc] = map[curr[0]][curr[1]] + 1;
                q.offer(new int[]{nr,nc});
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        for (int i = 0; i < N; i++) {
            sb = new StringBuilder();
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
