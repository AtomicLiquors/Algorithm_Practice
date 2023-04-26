package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

//반례
//https://www.acmicpc.net/board/view/72795
public class Main_실패_로봇청소기 {
    //14503_로봇청소기

    static int N, M;
    //static int r, c, d;
    static int nr, nc, nd;

    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, -1, 0, 1};

    static boolean terminate = false;

    static int cnt = 0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(r, c, d);

        System.out.println(cnt);

    }

    static void dfs(int r, int c, int d){

        if(map[r][c]==0){
            cnt++;
            map[r][c] = 2;
        }

        for (int dir = 1; dir <= 4; dir++) {
            nd = (d + dir)%4;
            nr = r + dR[nd];
            nc = c + dC[nd];

            //if(nr < 0 || nc < 0 || nr >= N || nc >= M)continue;
            if(map[nr][nc]==0){
                dfs(nr, nc, nd);
                //if(terminate) return;
                return;
            }
        }
        nr = r - dR[d];
        nc = c - dC[d];
        //if(nr < 0 || nc < 0 || nr >= N || nc >= M) return;
        if(map[nr][nc]==1 ){
            terminate = true;
            return;
        }
        dfs(nr, nc, d);
        if(terminate) return;
    }

}
