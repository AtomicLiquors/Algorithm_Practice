package SSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753 {

    static int V, E;
    static int[][] adjMatrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjMatrix = new int[V+1][V+1];
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjMatrix[from][to] = weight;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            int result = dijkstra(start, i);
            sb.append(result == Integer.MAX_VALUE ? "INF" : result).append('\n');
        }
        System.out.print(sb);
    }

    static int dijkstra(int start, int end){

        int[] dist = new int[V+1];
        boolean[] visited = new boolean[V+1];
        int min, curr;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int c = 1; c <= V; c++) {
            min = Integer.MAX_VALUE;
            curr = -1;

            for(int i = 1; i <= V; i++){
                if(!visited[i] && dist[i] < min){
                    min = dist[i];
                    curr = i;
                }
            }

            if(curr == -1)
                break;
            visited[curr] = true;
            if(curr == end)
                break;

            for(int i = 1; i <= V; i++){
                if(!visited[i] && adjMatrix[curr][i] != 0)
                    dist[i] = Math.min(dist[i], min + adjMatrix[curr][i]);
            }
        }

        return dist[end];
    }
}
