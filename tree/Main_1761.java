package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1761 {

    static int N;

    static ArrayList<Node>[] adjList;
    static boolean[] visited;

    private static class Node {
        int id;
        int weight;

        public Node(int id, int weight){
            this.id = id;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adjList[from].add(new Node(to, weight));
            adjList[to].add(new Node(from, weight));
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(dfs(from, to)).append('\n');
        }
        System.out.print(sb);
    }

    static int dfs(int from, int to){

        visited[from] = true;

        int result = 0;
        for (int i = 0; i < adjList[from].size(); i++) {
            Node stopover = adjList[from].get(i);

            if(!visited[stopover.id]){
                result = stopover.weight + dfs(stopover.id, to);
                break;
            }
        }

        visited[from] = false;
        return result;
    }
}
