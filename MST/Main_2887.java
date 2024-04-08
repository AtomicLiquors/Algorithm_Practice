package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int start;
    int end;
    int cost;

    Edge(int start,
    int end,
    int cost){
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}

class Coordinate{
    int x;
    int y;
    int z;

    Coordinate(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main_2887 {
    // https://steady-coding.tistory.com/117
    static int N;
    static int[] parents;
    static Coordinate[] coordinates;
    // static List<Edge> edgeList = new ArrayList<>();
    static Edge[] edges;

    static Edge createEdge(int idx1, int idx2){
        Coordinate c1 = coordinates[idx1];
        Coordinate c2 = coordinates[idx2];

        int cost = Integer.MAX_VALUE;

        int xGap = Math.abs(c1.x - c2.x);
        int yGap = Math.abs(c1.y - c2.y);
        int zGap = Math.abs(c1.z - c2.z);

        cost = Math.min(xGap, yGap);
        cost = Math.min(cost, zGap);

        return new Edge(idx1, idx2, cost);
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

    public static void main(String[] args) throws IOException {
        // 메모리 초과가 난 이유?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        coordinates = new Coordinate[N];
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }

        edges = new Edge[N-1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            coordinates[i] = new Coordinate(x, y, z);
        }

        int idx = -1;

        Arrays.sort(coordinates, (c1, c2) -> c1.x - c2.x);
        for (int i = 0; i < N-1; i++) {
            edges[++idx] = createEdge(i, i+1);
        }

        Arrays.sort(edges);

        long answer = 0;
        int count = 0;
        for (Edge edge : edges) {
            if(union(edge.start, edge.end)){
                answer += edge.cost;
                if(++count == N) break;
            }
        }

        System.out.println(answer);
    }
}
