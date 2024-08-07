package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16946 {

    static int dR[] = {0,0,-1,1};
    static int dC[] = {-1,1, 0,0};

    static int[][] movables, answer;
    static boolean[][] visited;
    static int N, M, id;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        movables = new int[N][M];
        visited = new boolean[N][M];
        answer = new int[N][M];
        id = -1;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
           String input = br.readLine();
            for (int j = 0; j < M; j++) {
               answer[i][j] = input.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(answer[i][j] > 0){
                    int r, c;
                    // 1) dfs로 movable한 칸 수 세기 뭐가 잘못됐나?
                    // 2) 4방탐색 할때 서로 같은 집합에 속해있단 걸 어떻게 간단하게 입증할까?
                    for (int k = 0; k < 4; k++) {
                        r = i + dR[k];
                        c = j + dC[k];
                        if(!isOuttaBound(r, c) && answer[r][c] == 0){
                            dfs(r, c, 1);
                            answer[i][j] += movables[r][c];
                        }
                    }
                }
               sb.append(answer[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(Arrays.deepToString(movables));
        System.out.print(sb);
    }

    static int dfs(int r, int c, int cnt){
        if(movables[r][c] > 0)
            return movables[r][c];

        visited[r][c] = true;

        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            nr = r + dR[dir];
            nc = c + dC[dir];

            if(!isOuttaBound(nr, nc) && !visited[nr][nc] && answer[nr][nc] == 0){
                cnt = dfs(nr, nc, cnt+1);
            }
        }
        return movables[r][c] = cnt;
    }

    static boolean isOuttaBound(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}

