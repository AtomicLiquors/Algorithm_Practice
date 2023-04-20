package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로탐색 {

    static int[][] map;
    static boolean[][] visited;
    static int N, M, endR, endC;
    static Queue<int[]> q = new ArrayDeque<>();

    static int[] dR = {0, 0, 1, -1};
    static int[] dC = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String line;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        endR = N-1;
        endC = M-1;

        visited = new boolean[N][M];

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = -(line.charAt(j)-'0');
            }
        }

        q.offer(new int[]{0, 0, 1});
        bfs();

    }

    static void bfs(){
        int[] curr;
        int nr, nc, cnt;
        while(!q.isEmpty()){
            curr = q.poll();

            if(curr[0]==endR && curr[1]==endC) {
                System.out.println(curr[2]);
                return;
            }

            for (int dir = 0; dir < 4; dir++) {
                nr = curr[0] + dR[dir];
                nc = curr[1] + dC[dir];
                cnt = curr[2]+1;
                if(nr<0 || nc<0 || nr >= N || nc >= M) continue;
                if(map[nr][nc] != -1) continue;
                q.offer(new int[]{nr, nc, cnt});
                map[nr][nc] = cnt;
            }

        }
    }
}
