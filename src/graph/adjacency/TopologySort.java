package graph.adjacency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort {
    static class Node{
        int vertex;
        Node link;

        public Node(int vertex, Node link) {
            super();
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int N, M;
    static Node[] adjList;

    static int[] inDegree;
    //"진입차수 갯수"

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new Node[N+1];
        inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adjList[from] = new Node(to, adjList[from]);
            inDegree[to]++;
        }

        ArrayList<Integer> list = topologySort();
        if(list.size()==N) {
            //모든 정점을 도는 데 성공한 경우
            for(Integer vertex : list) {
                System.out.print(vertex+" ");
            }
        }else {
            //싸이클에 빠져서 모든 정점을 돌지 못한 경
            System.out.println("cycle");
        }

    }

    static ArrayList<Integer> topologySort(){

        ArrayList<Integer> orderList = new ArrayList<Integer>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if(inDegree[i]==0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            orderList.add(cur);

            for(Node temp = adjList[cur]; temp != null; temp = temp.link) {
                //인접 리스트를 돌면서 차수를 하나씩 깐다.
                if(--inDegree[temp.vertex]==0) {
                    //간선이 0이 되어버린 친구들을 큐에 넣는다.
                    q.offer(temp.vertex);
                }
            }
        }
        return orderList;

    }

}