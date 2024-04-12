package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class Main_6497 {

    static Edge_6497[] edges;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;

            parents = new int[m];
            for (int i = 1; i < m; i++) {
                parents[i] = i;
            }
            edges = new Edge_6497[n];

            int totalCost = 0;
            int minimumCost = 0;
            int answer;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                totalCost += z;
                edges[i] = new Edge_6497(x, y, z);
            }

            Arrays.sort(edges);

            int cnt = 0;
            for(Edge_6497 edge : edges){
                if(!union(edge.x, edge.y))
                    continue;
                minimumCost += edge.z;
                if(++cnt == m-1)
                    break;
            }

            answer = totalCost - minimumCost;
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int findSet(int a){
        if(a == parents[a])
            return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot)
            return false;

        parents[bRoot] = aRoot;
        return true;
    }
}

class Edge_6497 implements Comparable<Edge_6497>{
    int x;
    int y;
    int z;

    public Edge_6497(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Edge_6497 e){
        return this.z - e.z;
    }
}
