package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토 {

    static int M, N, map[][];
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dX = {0, 0, -1, 1};
    static int[] dY = {-1, 1, 0, 0};

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) q.offer(new int[]{i, j, 0});
                //System.out.print(map[i][j]);
            }
            System.out.println();
        }

        bfs();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }

    static void bfs(){
        int[] curr;
        int nx, ny;
        while (!q.isEmpty()){
            //System.out.println(Arrays.deepToString(map));
            curr = q.poll();
            cnt = curr[2];


            for (int dir = 0; dir < 4; dir++) {
                nx = curr[0]+dX[dir];
                ny = curr[1]+dY[dir];

                if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny]==0){
                    q.offer(new int[]{nx, ny, cnt+1});
                    map[nx][ny] = 1;
                }
            }

        }
    }
}
