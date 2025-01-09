package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT_7727_FAILED {

    static int N, M, map[][], mates[][], visited[][], answer = 0;
    static boolean[][] picked;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        picked = new boolean[N][N];
        mates = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            mates[i][0] = r;
            mates[i][1] = c;
            answer += map[r][c];
            picked[r][c] = true;
        }

        backtrack(0, mates[0][0], mates[0][1], 0, answer);
        System.out.println(answer);
        br.close();
    }

    static void backtrack(int time, int r, int c, int mate, int sum){
        answer = Math.max(sum, answer);

        if(time == 3){
            if(++mate < M)
                backtrack(0, mates[mate][0], mates[mate][1], mate, sum);
            return;
        }



        int nr, nc, nSum;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];

            if(isOuttaBound(nr, nc) || visited[nr][nc] == time + 1)
                continue;

            visited[nr][nc] = time + 1;
            int value = map[r][c];
            map[r][c] = 0;

            backtrack(time + 1, nr, nc, mate, sum + value);

            visited[r][c] = 0;
            map[r][c] = value;

        }


    }

    static boolean isOuttaBound(int r, int c){
        return r < 0  || c < 0 || r >= N || c >= N;
    }
}
