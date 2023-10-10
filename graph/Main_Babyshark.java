package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Babyshark {
    public static void main(String[] args) throws IOException {
        int[] dR = {-1, 0, 0, 1};
        int[] dC = {0, -1, 1, 0};
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
                   start = new int[]{i, j, 0};
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
                    System.out.println(nr);
                    System.out.println(nc);
                    System.out.println(map[nr][nc]);
                    if(++consumed == size) {
                        size++;
                        consumed = 0;
                    }
                    map[nr][nc] = 0;
                    elapsed += curr[2]+1;
                    System.out.println(elapsed);

                    System.out.println("=========");

                    queue = new ArrayDeque<>();
                    visited = new boolean[N][N];
                    queue.offer(new int[]{nr, nc, 0});
                    break; /* had to sout all curr[2] to figure this one */
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
        /*
        https://www.acmicpc.net/board/view/30275
        * 같은 최단거리에 있는 먹이들 중 우선순위는 위에 있는 물고기, 높이도 같다면 왼쪽에 있는 물고기를 섭취해야 하는데 단순히 BFS만 사용하면 4번 테스트 케이스에서 오류가 난다.
        만약 우선순위를 제대로 고려하지 않고 그냥 BFS를 사용했다면 이 테스트 케이스에서 56이 나올 것이다.



이유는 (0,2)에서 길이 3짜리 물고기를 먹은 뒤 (0,4) 혹은 (1,1) 둘 모두 최단거리 2 에 있는 물고기고, 먹을 수 있다. 문제 조건에 따르면 (0,4)에 있는 물고기가 더 우선순위가 높다. 그러나 단순 BFS로 위,왼쪽,오른쪽,아래 순서로의 탐색만 고려했을 경우 (1,1)에 있는 물고기를 먹게 된다.*/
    }
}
