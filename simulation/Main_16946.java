package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16946 {
    // 330836KB	4748ms

    // 모범답안 : https://www.acmicpc.net/source/80625714
    // 151648KB	592ms

    static int dR[] = {0,0,-1,1};
    static int dC[] = {-1,1, 0,0};

    static ArrayList<Integer> movementPerIds;
    static int[][] ids, map;
    static boolean[][] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ids = new int[N][M];
        visited = new boolean[N][M];
        map = new int[N][M];
        boolean[] isSelected;

        movementPerIds = new ArrayList<>();
        movementPerIds.add(0);

        Queue<int[]> tiles = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
           String input = br.readLine();
            for (int j = 0; j < M; j++) {
               map[i][j] = input.charAt(j) - '0';

               if(map[i][j] == 0)
                   tiles.offer(new int[]{i, j});
            }
        }

        StringBuilder sb = new StringBuilder();

        int id = 0;
        while(!tiles.isEmpty()){
            int[] tile = tiles.poll();
            int r = tile[0];
            int c = tile[1];

            if(ids[r][c] == 0){
                movementPerIds.add(++id, 0);
                bfs(r, c, id);
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(map[r][c] > 0){
                    int nr, nc;
                    isSelected = new boolean[id+1];
                    for (int k = 0; k < 4; k++) {
                        nr = r + dR[k];
                        nc = c + dC[k];
                        if(!isOuttaBound(nr, nc) && map[nr][nc] == 0 && !isSelected[ids[nr][nc]]){
                            int currId = ids[nr][nc];
                            isSelected[currId] = true;
                            map[r][c] += movementPerIds.get(currId);
                        }
                    }
                }
               sb.append(map[r][c] % 10);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static void bfs(int sr, int sc, int id){

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{sr, sc});
        ids[sr][sc] = id;

        int r, c, count = 0;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            r = curr[0];
            c = curr[1];
            count++;

            int nr, nc;
            for (int dir = 0; dir < 4; dir++) {
                nr = r + dR[dir];
                nc = c + dC[dir];

                if(!isOuttaBound(nr, nc) && map[nr][nc] == 0 && ids[nr][nc] == 0){
                    ids[nr][nc] = id;
                    que.offer(new int[]{nr, nc});
                }
            }
        }
        movementPerIds.add(id, count);
    }

    static boolean isOuttaBound(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}

