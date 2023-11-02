package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1520 {
    // 오답 : 4방 탐색을 고려해야 한다.
    static int M;
    static int N;
    static int[][] map;
    static int[][] table;

    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        table = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        table[0][0] = 1;

        queue = new ArrayDeque<int[]>();
        queue.offer(new int[]{0,1});
        queue.offer(new int[]{1,0});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            mark(curr[0], curr[1]);
        }

        System.out.println(table[M-1][N-1]);
    }

    static void mark(int i, int j) {
        //기저조건
        int value = 0;

        if(check(i-1, j) && (map[i-1][j] > map[i][j])){
            value += table[i-1][j];
        }

        if(check(i, j-1) && (map[i][j-1] > map[i][j])){
            value += table[i][j-1];
        }

        table[i][j] = value;

        int nr, nc;
        nr = i + 1;
        nc = j;
        if(check(nr, nc) && (map[i][j] > map[nr][nc])){
            queue.offer(new int[]{nr, nc});
        }

        nr = i;
        nc = j + 1;
        if(check(nr, nc) && (map[i][j] > map[nr][nc])){
            queue.offer(new int[]{nr, nc});
        }
    }

    static boolean check(int i, int j){
        return (i >= 0 && j >= 0 && i < M && j < N);
    }
}
