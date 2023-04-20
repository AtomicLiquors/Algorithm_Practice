package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {

    static int M, N, H, box[][][];
    static Queue<int[]> q = new ArrayDeque<>();
    static int[] dX = {0, 0, -1, 1, 0, 0};
    static int[] dY = {-1, 1, 0, 0, 0, 0};
    static int[] dH = {0, 0, 0, 0, -1, 1};

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];

        int input;
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    input = Integer.parseInt(st.nextToken());
                    box[k][i][j] = input;
                    if (input == 1) q.offer(new int[]{i, j, k, 0});
                    //System.out.print(input);
                }
                //System.out.println();
            }
        }

        bfs();


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if(box[k][i][j]==0){
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(cnt);

    }

    static void bfs(){
        int[] curr;
        int nx, ny, nh;
        while (!q.isEmpty()){
            //System.out.println(Arrays.deepToString(box[0]));

            curr = q.poll();
            cnt = curr[3];


            for (int dir = 0; dir < 6; dir++) {
                nx = curr[0]+dX[dir];
                ny = curr[1]+dY[dir];
                nh = curr[2]+dH[dir];

                if(nx>=0 && ny>=0 && nh>=0 && nx<N && ny<M && nh<H && box[nh][nx][ny]==0){
                    q.offer(new int[]{nx, ny, nh, cnt+1});
                    box[nh][nx][ny] = 1;
                }
            }

        }
    }
}
