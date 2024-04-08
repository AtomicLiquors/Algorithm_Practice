package MST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge1922 implements Comparable<Edge1922> {
    int a;
    int b;
    int cost;

    public Edge1922(int a, int b, int cost){
        this.a = a;
        this.b = b;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge1922 e) {
        return this.cost - e.cost;
    }
}

public class Main_1922 {

    static int N, M, parents[], costs[][];
    static Edge1922[] edgeList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        edgeList = new Edge1922[M];

        // 비용 정보 저장
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge1922(a, b, cost);
        }

        Arrays.sort(edgeList);

        int result = 0, count = 0;

        for (Edge1922 edge : edgeList) {
            if(union(edge.a, edge.b)){
                result += edge.cost;
                if(++count == N-1) break;
            }
        }

        System.out.println(result);
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

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
