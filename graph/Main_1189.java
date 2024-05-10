package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1189 {

    static int R, C, K, answer;
    static String[] map;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, 1, -1};
    static boolean[][] visited = new boolean[R][C];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        answer = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new String[R];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine();
        }

        dfs(R-1, 0, 1);

        System.out.println(answer);
        br.close();
    }

    static void dfs(int r, int c, int dist){
        if(dist == K){
            answer += ( (r == 0 && c == C-1) ? 1 : 0);
            return;
        }

        visited[r][c] = true;

        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C)
                continue;

            if(!visited[nr][nc] && map[nr].charAt(nc) != 'T')
                dfs(nr, nc, dist+1);
        }

        visited[r][c] = false;
    }
}
