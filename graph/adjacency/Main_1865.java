package graph.adjacency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge2 {
    int start;
    int end;
    int value;
    int idx;

    Edge2(int start, int end, int value, int idx) {
        this.start = start;
        this.end = end;
        this.value = value;
        this.idx = idx;
    }
}

public class Main_1865 {

    static ArrayList<Edge2> edge2s;
    static boolean[] visited;
    static ArrayList<Edge2>[] edgesPerPoint;
    static int[] edgeCountPerPoint;
    static int edgeIdx;
    static int startPoint ,totalEdges;
    static boolean answer;

    public static void main(String[] args) throws IOException {
// visited 외에 사이클링 체크.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st;


        for (int t = 0; t < TC; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            totalEdges = 2 * M + W;
            edge2s = new ArrayList<>();
            edgesPerPoint = new ArrayList[N+1];
            edgeCountPerPoint = new int[N+1];
            edgeIdx = 0;
            Edge2 edge2;
            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                if(i >= M) T = -T;

                if(edgesPerPoint[S] == null)
                    edgesPerPoint[S] = new ArrayList<>();
                edge2 = new Edge2(S, E, T, edgeIdx);
                edge2s.add(edge2);
                edgesPerPoint[S].add(edge2);
                edgeCountPerPoint[S]++;
                edgeIdx++;

                if(i < M){
                    edge2 = new Edge2(E, S, T, edgeIdx);
                    edge2s.add(edge2);
                    if(edgesPerPoint[E] == null)
                        edgesPerPoint[E] = new ArrayList<>();
                    edgesPerPoint[E].add(edge2);
                    edgeCountPerPoint[E]++;
                    edgeIdx++;
                }
            }


            answer = false;
            for (int i = 1; i <= N; i++) {
                visited = new boolean[totalEdges];
                startPoint = i;
                travel(i, 0, 0);
                if(answer) break;
            }

            System.out.println(answer? "YES" : "NO");
        }
    }

    static void travel(int curr, int cnt, long sum){
        if(cnt > 2 * totalEdges)
            return;
        if( cnt > 0 && curr == startPoint){
            answer = sum < 0;
        }

        for (int i = 0; i < edgeCountPerPoint[curr]; i++) {
            Edge2 edge2 = edgesPerPoint[curr].get(i);
            if(!visited[edge2.idx]){
                visited[edge2.idx] = true;travel(edge2.end, cnt + 1, sum + edge2.value);
                visited[edge2.idx] = false;
            }
        }
    }
}
