package SSP.Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_1753 {

    private static class AdjNode{
        int to;
        int weight;

        public AdjNode(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static int V, E, INF = Integer.MAX_VALUE;

    static boolean[] visited;
    static int[] shortestPath;
    static ArrayList<AdjNode>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        shortestPath = new int[V+1];
        Arrays.fill(shortestPath, INF);
        visited = new boolean[V+1];

        adjList = new ArrayList[V+1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new AdjNode(to, weight));
        }

        dijkstra(start);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(shortestPath[i] == INF ? "INF" : shortestPath[i]).append('\n');
        }

        br.close();
        System.out.print(sb);

    }

    static void dijkstra(int start){

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a1, a2) -> a1[1] - a2[1]
        );

        pq.offer(new int[]{start, 0});

        while(!pq.isEmpty()){
             int[] curNode = pq.poll();
             int curr = curNode[0];
             int distance = curNode[1];

             if(visited[curr])
                 continue;
             visited[curr] = true;
             shortestPath[curr] = distance;

            for (int i = 0; i < adjList[curr].size(); i++){
                AdjNode adjNode = adjList[curr].get(i);
                int next = adjNode.to;
                int weight = adjNode.weight;
                pq.offer(new int[]{next, distance + weight});
            }
        }
    }
}
