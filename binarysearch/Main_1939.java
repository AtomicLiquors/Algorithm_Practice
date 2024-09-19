package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1939 {
    // 메모리 초과.
    static int N, to, adjMatrix[][];
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        adjMatrix = new int[N+1][N+1];
        visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            adjMatrix[start][end] = Math.max(limit, adjMatrix[start][end]);
            adjMatrix[end][start] = Math.max(limit, adjMatrix[end][start]);
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        to = Integer.parseInt(st.nextToken());

        visited[from] = true;
        dfs(from, Integer.MAX_VALUE);
        System.out.println(answer);
    }
    
    static void dfs(int curr, int limit){
        if(curr == to){
            answer = Math.max(answer, limit);
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i] && adjMatrix[curr][i] > 0){
                visited[i] = true;
                dfs(i, Math.min(limit, adjMatrix[curr][i]));
                visited[i] = false;
            }
        }
    }
}
