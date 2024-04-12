package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int P = 0;
        int[][] map;
        int[][] distances;
        int[] dR = {-1, 1, 0, 0};
        int[] dC = {0, 0, -1, 1};
        final int INF = Integer.MAX_VALUE;

        while(N != 0){
            map = new int[N][N];
            distances = new int[N][N];
            for (int[] rows : distances){
                Arrays.fill(rows, INF);
            }
            distances[0][0] = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 인접한 놈들에 대해 = 4방탐색

            // 이콩이인가?

            System.out.printf("Problem %d: %d\n", ++P, distances[N-1][N-1]);
            N = Integer.parseInt(br.readLine());
        }
    }
}
