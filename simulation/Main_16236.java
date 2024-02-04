package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236 {
        static int[] dR = {-1, 0, 0, 1};
        static int[] dC = {0, -1, 1, 0};
static int N, startR, startC;
        static int[][] map;
        static int elapsed = 0;
        static int size = 2;
        static int consumed = 0;
        static boolean[][] visited;
        static boolean hasConsumedFish = true;
        public static void main(String[] args) throws IOException {

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                visited = new boolean[N][N];
                StringTokenizer st;

                for (int i = 0; i < N; i++) {
                        st = new StringTokenizer(br.readLine());
                        for (int j = 0; j < N; j++) {
                                map[i][j] = Integer.parseInt(st.nextToken());
                                if(map[i][j] == 9){
                                        startR = i;
                                        startC = j;
                                        map[i][j] = 0;
                                }
                        }
                }

                while(hasConsumedFish){
                        BFS(startR, startC);
                }

                System.out.println(elapsed);
        }

        static void BFS(int r, int c){
                System.out.println("begun");
                hasConsumedFish = false;
                PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
                        if(o1[0] == o2[0]) return o1[1] - o2[1];
                        else return o1[0] - o2[0];
                });
                queue.offer(new int[]{r, c, 0});
                visited = new boolean[N][N];

                while(!queue.isEmpty()){
                        int[] curr = queue.poll();
                        System.out.println(curr[0] + " " + curr[1]);
                        visited[curr[0]][curr[1]] = true;
                        int nr, nc;
                        for (int i = 0; i < 4; i++) {
                                nr = curr[0] + dR[i];
                                nc = curr[1] + dC[i];
                                if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                                if(map[nr][nc] > size) continue;
                                else if(map[nr][nc] != 0 && map[nr][nc] < size ){
                                        if(++consumed == size) {
                                                size++;
                                                consumed = 0;
                                        }
                                        elapsed += curr[2]+1;
                                        System.out.println(elapsed);
                                        hasConsumedFish = true;
                                        startR = nr;
                                        startC = nc;
                                        map[nr][nc] = 0;
                                        queue.clear();
                                        break;
                                }else queue.offer(new int[]{nr, nc, curr[2]+1});
                        }

                }

        }
}