package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500 {

    static int R, C, map[][], answer = 0;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
               dfs(r, c, 1, 0);
               tShape(r, c);
            }
        }

        System.out.println(answer);
    }

    static void dfs(int r, int c, int cnt, int sum){
        visited[r][c] = true;

        sum += map[r][c];

        if(cnt == 4){
            answer = Math.max(sum, answer);
        }else{
            int nr, nc;
            for (int dir = 0; dir < 4; dir++) {
                nr = r + dR[dir];
                nc = c + dC[dir];
                if(nr < 0 || nc < 0 || nr >= R || nc >= C || visited[nr][nc])
                    continue;
                dfs(nr, nc, cnt+1, sum);
            }
        }
        visited[r][c] = false;
    }

    static void tShape(int r, int c){
        int sum = map[r][c];
        int cnt = 1;

        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];
            if(nr < 0 || nc < 0 || nr >= R || nc >= C)
                continue;
            sum += map[nr][nc];
            cnt++;
        }

        if(cnt == 4){
            answer = Math.max(answer, sum);
        }else if(cnt == 5){
            for (int dir = 0; dir < 4; dir++) {
                nr = r + dR[dir];
                nc = c + dC[dir];
                answer = Math.max(answer, sum - map[nr][nc]);
            }
        }
    }
}
