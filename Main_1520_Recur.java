import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1520_Recur {

    static int N, M;
    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};
    static int[][] map, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        result = new int[M][N];
        result[M-1][N-1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int recur(int r, int c){
        int routes = 0;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            
            if(nr < 0 || nc < 0 || nr >= M || nc >= N)
                continue;
            else if(map[nr][nc] >= map[r][c])
                continue;
            
            if(result[nr][nc] == 0)
                routes += recur(nr, nc);
            else
                routes += result[nr][nc];
        }

        return routes;
    }
}
