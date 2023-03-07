import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static int[][] map;
    static boolean[] visited;
    static int max;

    static int R, C;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        max = 0;

        for (int i = 0; i < R; i++) {
            String line  = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j) - 65;
            }
        }

        visited = new boolean[26];

        dfs(0, 0, 1);
        System.out.println(max);

    }

    static void dfs(int r, int c, int cnt){
        visited[map[r][c]] = true;
        max = Math.max(cnt, max);

        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];
            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if(!visited[map[nr][nc]])
                dfs(nr, nc, cnt+1);
        }
        visited[map[r][c]] = false;
    }
}