package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Babyshark {
    public static void main(String[] args) throws IOException {
        int[] dR = {-1, 0, 1, 0};
        int[] dC = {0, -1, 0, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        StringTokenizer st;
        int[] start = {0, 0};
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
               if(map[i][j] == 9){
                   start = new int[]{i, j, 1};
                   map[i][j] = 0;
               }
            }
        }

        int elapsed = 0;
        int size = 2;
        int consumed = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int nr, nc;

            for (int i = 0; i < 4; i++) {

                nr = curr[0] + dR[i];
                nc = curr[1] + dC[i];
                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                if(map[nr][nc] > size) continue;
                visited[nr][nc] = true;
                if(map[nr][nc] != 0 && map[nr][nc] < size ){
                    if(++consumed == size) {
                        size++;
                        consumed = 0;
                    }
                    map[nr][nc] = 0;
                    elapsed += curr[2];
                    queue = new ArrayDeque<>();
                    visited = new boolean[N][N];
                    queue.offer(new int[]{nr, nc, 1});
                }else{
                    queue.offer(new int[]{nr, nc, curr[2]+1});
                }
            }
        }

        System.out.println(elapsed);

//        corner case

        /*
        6
5 4 3 2 3 4
4 3 2 3 4 5
3 2 9 5 6 6
2 1 2 3 4 5
3 2 1 6 5 4
6 6 6 6 6 6
        *
        *6
1 1 1 1 1 1
2 2 6 2 2 3
2 2 5 2 2 3
2 2 2 4 6 3
0 0 0 0 0 6
0 0 0 0 0 9
        * */
    }
}
