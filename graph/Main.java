package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static Queue<int[]> queue = new ArrayDeque<>();
    static boolean[][] connectionMatrix;
static    int[][] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer( br.readLine() );
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        connectionMatrix = new boolean[N+1][N+1];
        result = new int[N+1][N+1];

        int x, y;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            connectionMatrix[x][y] = connectionMatrix[y][x] = true;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(connectionMatrix[i][j]){
                    DFS(i, j, 1);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int person = 0;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
          for(int j = 1; j <= N; j++){
              sum += result[i][j];
          }
          if(min > sum){
              person = i;
              min = sum;
          }
        }

        System.out.println(person);
    }

    static void DFS(int prev, int curr, int count){
       result[prev][curr] = result[curr][prev] = (result[curr][prev] == 0 ? count: Math.min(result[curr][prev],0));

       for(int j = 1; j <= N; j++){
           if(connectionMatrix[curr][j] )
               DFS(curr, j, count + 1);
       }
    }
}
