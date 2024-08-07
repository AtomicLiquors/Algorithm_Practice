package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1103 {
    // TLE
    // Union Find로 사이클 탐지하는 알고리즘?
    static int N, M, answer;
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    static String[] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new String[N];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
           map[i] = br.readLine();
        }

        dfs(0,0,1);
        System.out.println(answer);
    }

    static void dfs(int r, int c, int cnt){
        if(answer == -1)
            return;

        answer = Math.max(answer, cnt);

        int dist = map[r].charAt(c) - '0';

        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir] * dist;
            nc = c + dC[dir] * dist;

            if(isInBound(nr, nc)){
                if(visited[nr][nc]){
                    answer = -1;
                    return;
                }
                visited[nr][nc] = true;
                dfs(nr, nc, cnt+1);
                visited[nr][nc] = false;
            }
        }
    }

    static boolean isInBound(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M && map[r].charAt(c) != 'H';
    }

}
