package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {

    static int[] dR = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dC = {1, -1, 1, 0, -1, 1, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int result;
    static int R, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            result = 0;
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            if(C==0 && R == 0) return;
            map = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            //result ++, dfs
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if(map[i][j] == 1){
                        result++;
                        dfs(i, j);
                        //System.out.println(Arrays.deepToString(map));
                    }
                }
            }

            System.out.println(result);
        }
    }

    static void dfs(int r, int c){
        map[r][c] = 2;
        int nr, nc;
        for (int dir = 0; dir < 8; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];
            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            else if(map[nr][nc]!=1) continue;
            dfs(nr, nc);
        }
    }
}
