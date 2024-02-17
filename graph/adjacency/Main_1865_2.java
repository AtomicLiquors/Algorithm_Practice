package graph.adjacency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int value;
    int idx;

    Edge(int start, int end, int value, int idx) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.idx = idx;
    }
}

public class Main_1865_2 {

    static int N;
    static ArrayList<Edge> edges;
    static ArrayList<Edge>[] edgesPerPoint;
    static int[] edgeCountPerPoint;
    static int edgeIdx;
    static int startPoint ,totalEdges;
    static boolean answer;

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            parents = new int[N+1];
            edges = new ArrayList<>();
            makeSet();

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(i >= M) T = -T;


                if(edgesPerPoint[S] == null)
                    edgesPerPoint[S] = new ArrayList<>();
                Edge edge = new Edge(S, E, T, edgeIdx);
                edges.add(edge);
                edgesPerPoint[S].add(edge);
                edgeCountPerPoint[S]++;
                edgeIdx++;

                if(i < M){
                    edge = new Edge(E, S, T, edgeIdx);
                    edges.add(edge);
                    if(edgesPerPoint[E] == null)
                        edgesPerPoint[E] = new ArrayList<>();
                    edgesPerPoint[E].add(edge);
                    edgeCountPerPoint[E]++;
                    edgeIdx++;
                }
            }


            answer = false;
            for (int i = 1; i <= N; i++) {
                startPoint = i;
                // 점마다 돌면서
                // 시작, 끝이 같은 집합인 놈이 나왔다면? 사이클을 찾은 것. -> 사이클 합이 음수가 되는지 확인해라.
                // 확인하고 나서 방문처리는 어떻게 할래?

                if(answer) break;
            }

            System.out.println(answer? "YES" : "NO");
        }
    }

    static void makeSet(){
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[aRoot] = bRoot;
        return true;
    }

    static int findSet(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = findSet(parents[a]);
    }

    static void traverse(){

    }
}
