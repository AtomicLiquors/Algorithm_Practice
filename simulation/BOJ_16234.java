// 인구 이동

package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234 {

    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int N, L, R, map[][];
    static int people, lands;
    static boolean visited[][];

    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        int answer = -1;

        queue = new ArrayDeque<>();

        while(flag){
            answer++;
            flag = false;

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        people = 0;
                        lands = DFS(i, j);
                        if(lands > 1){
                            flag = true;
                            int avg = people/lands;
                            while(!queue.isEmpty()){
                                int[] curr = queue.poll();
                                map[curr[0]][curr[1]] = avg;
                            }
                        }else{
                            queue.poll();
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static int DFS(int r, int c){
        int cities = 1;
        visited[r][c] = true;
        queue.offer(new int[]{r, c});
        people += map[r][c];

        int nr, nc, nGap;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
                continue;
            nGap = Math.abs(map[nr][nc] - map[r][c]);
            if(nGap >= L && nGap <= R)
               cities += DFS(nr, nc);
        }
        return cities;
    }
}
