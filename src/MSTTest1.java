import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Scanner;

public class MSTTest1 {

    static class Edge implements Comparable<Edge>{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    static int V, E;
    static Edge[] edgeList;
    static int[] parents;

    public static void main(String[] args) {
        makeSet();

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            edgeList[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        makeSet();

        Arrays.sort(edgeList);

        int result=0, count = 0;

        for (Edge edge:
             edgeList) {
            if (union(edge.from, edge.to)){
                result += edge.weight;
                if(++count==V-1) break;
            }
        }

        System.out.println(result);
    }

    static void makeSet(){
        parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a){
        if(a==parents[a]) return a;
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