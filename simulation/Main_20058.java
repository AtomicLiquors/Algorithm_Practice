package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20058 {
    static int size, sizeLimit, A[][], largestBulk;
    static int[] dR = {-1, 1, 0, 0};
    static int[] dC = {0, 0, -1, 1};
    static int sum = 0;

    static boolean[][] heated, melted, visited;

    static Queue<int[]> meltQue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        size = (int)Math.pow(2, N);
        sizeLimit = size - 1;
        A = new int[size][size];

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                sum += A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            int L = Integer.parseInt(st.nextToken());
            fireStorm(L);
        }

        System.out.println(sum);
        visited = new boolean[size][size];
        findLargestBulk();
        System.out.println(largestBulk);
    }

    static void fireStorm(int L){
        int length = (int)Math.pow(2, L);
        int limit = length - 1;

        for (int i = 0; i < size; i += length) {
            for (int j = 0; j < size; j += length) {
                   rotate(i, j, limit);
            }
        }

        melt();
    }

    static void rotate(int r, int c, int limit){
        // 출발점 r, c에 대해 시계방향 90도 회전. limit은 전체 길이에서 1을 뺀 값을 의미.
        int limitR = r + limit;
        int limitC = c + limit;
        Queue<Integer> rotateQue = new ArrayDeque<>();
        for (int i = r; i <= limitR; i++) {
            for (int j = c; j <= limitC; j++) {
               rotateQue.offer(A[i][j]);
            }
        }

        for (int j = limitC; j >= c; j--) {
            for (int i = r; i <= limitR; i++) {
               A[i][j] = rotateQue.poll();
            }
        }
    }

    static void melt(){

        heated = new boolean[size][size];
        melted = new boolean[size][size];

        for (int i = 0; i < size; i++) {

            for (int j = 0; j < size; j++) {
               if(i % sizeLimit == 0) heat(i, j);
               if(j % sizeLimit == 0) heat(i, j);

               if(A[i][j] <= 0){
                   int ni, nj;
                   for (int dir = 0; dir < 4; dir++) {
                       ni = i + dR[dir];
                       nj = j + dC[dir];
                       if(isOuttaBound(ni, nj) || A[ni][nj] <= 0) continue;
                       heat(ni, nj);
                   }
               }
            }
        }
        while(!meltQue.isEmpty()){
            int[] curr = meltQue.poll();
            A[curr[0]][curr[1]]--;
            sum--;
        }
    }

    static void heat(int r, int c){
        if(heated[r][c]){
            if(!melted[r][c]){
                if(A[r][c] > 0){
                   meltQue.offer(new int[]{r, c});
                }
                melted[r][c] = true;
            }
        }else{
            heated[r][c] = true;
        }
    }

    static void findLargestBulk(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(!visited[i][j] && A[i][j] > 0)
                   largestBulk = Math.max(largestBulk, dfs(i, j));
            }
        }
    }

    static int dfs(int r, int c){
        int sum = 1;
        visited[r][c] = true;
        int nr, nc;
        for (int i = 0; i < 4; i++) {
            nr = r + dR[i];
            nc = c + dC[i];
            if(isOuttaBound(nr, nc) || visited[nr][nc] || A[nr][nc] <= 0) continue;
            sum += dfs(nr, nc);
        }
        return sum;
    }

    static boolean isOuttaBound(int r, int c){
         return r < 0 || c < 0 || r >= size || c >= size;
    }
}
