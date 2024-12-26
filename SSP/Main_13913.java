package SSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_13913 {

    private static class Node{
        int pos;
        int dist;
        Node prev;

        public Node(int pos, int dist, Node prev){
            this.pos = pos;
            this.dist = dist;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int INF = 100001;
        boolean[] visited = new boolean[INF];

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a1, a2) -> a1.dist - a2.dist
        );
        pq.offer(new Node(N, 0, null));

        Node curr = null;

        while(!pq.isEmpty()){
            curr = pq.poll();
            int pos = curr.pos;

            if(pos == K)
                break;
            else if(pos >= INF || visited[pos])
                continue;
            visited[pos] = true;

            int dist = curr.dist;

            pq.offer(new Node(pos + 1, dist + 1, curr));
            if(pos > 0){
                pq.offer(new Node(pos * 2, dist + 1, curr));
                pq.offer(new Node(pos - 1, dist + 1, curr));
            }
        }

        int totalDist = curr.dist;
        int[] path = new int[totalDist+1];
        for (int i = totalDist; i >= 0; i--) {
            path[i] = curr.pos;
            curr = curr.prev;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(totalDist).append('\n');
        for (int i = 0; i <= totalDist; i++) {
            sb.append(path[i]).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}
