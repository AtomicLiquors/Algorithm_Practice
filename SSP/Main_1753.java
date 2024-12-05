package SSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class AdjNode {

    int to;
    int weight;

    public AdjNode(int to, int weight){
        this.to = to;
        this.weight = weight;
    }

}

public class Main_1753 {

    static int V, E;
    static ArrayList<AdjNode>[] adjList;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new AdjNode(to, weight));
        }

        dist = new int[V+1];
        visited = new boolean[V+1];

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            int result = dijkstra(start, i);
            sb.append(result == Integer.MAX_VALUE ? "INF" : result).append('\n');
        }
        System.out.print(sb);
    }

    static int dijkstra(int start, int end){

        Arrays.fill(dist, 0);
        Arrays.fill(visited, false);

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

            for(int i = 0; i < adjList[curr].size(); i++){
                AdjNode adjNode = adjList[curr].get(i);
                int to = adjNode.to;
                int weight = adjNode.weight;

                if(!visited[to])
                    dist[to] = Math.min(dist[to], min + weight);
            }
        }

        return dist[end];
    }
}
