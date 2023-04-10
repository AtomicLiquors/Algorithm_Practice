package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_바이러스 {

    static int V, E, map[][];
    static boolean[] visited;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        map = new int[V+1][V+1];
        visited = new boolean[V+1];
        E = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int from, to;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            map[from][to] = map[to][from] = 1;
        }

        visited[1] = true;
        dfs(1);

        System.out.println(cnt-1);
    }

    static void dfs(int v){
        cnt++;
        for (int i = 1; i <= V; i++) {
            if(!visited[i] && map[v][i]!=0) {
                visited[i] = true;
                map[v][i] = 2;
                dfs(i);
            }
        }
    }
}
