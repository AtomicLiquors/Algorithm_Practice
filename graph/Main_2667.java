package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_2667 {
    static int N;
    static boolean[][] map;
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (input.charAt(j) == '1');
            }
        }

        int residence = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if(map[r][c]){
                    residence++;
                    pq.offer(dfs(r, c));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(residence).append('\n');
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append('\n');
        }
        System.out.print(sb);
    }

    static int dfs(int r, int c){
        map[r][c] = false;
        int nr, nc;
        int houses = 1;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];
            if(isInBound(nr, nc)){
                houses += dfs(nr, nc);
            }
        }
        return houses;
    }

    static boolean isInBound(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N && map[r][c];
    }

}
