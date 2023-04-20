package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_old {

    static int goal;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            goal = Integer.parseInt(st.nextToken()) - 1;
            visited = new boolean[goal+1];

            bfs(start, 0, 0);

        }
    }

    static void bfs(int pos, int dist, int cnt){

        Queue<int[]> q = new ArrayDeque<>();
        visited[dist] = true;
        q.offer(new int[]{pos, dist, cnt});
        int nextPos, nextDist;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            visited[curr[0]] = true;

            curr[2]++;

            if(curr[0]==goal){
                System.out.println(curr[2]);
                return;
            }

            nextDist = curr[1] + 1;
            nextPos = curr[0] + nextDist;

            if(nextPos <= goal && !visited[nextPos])
                q.offer(new int[]{nextPos, nextDist, curr[2]});
            nextPos--;
            nextDist--;
            if(nextPos <= goal && nextDist > 0 && !visited[nextPos])
                q.offer(new int[]{nextPos, nextDist, curr[2]});
            nextPos--;
            nextDist--;
            if(nextPos <= goal && nextDist > 0 && !visited[nextPos])
                q.offer(new int[]{nextPos, nextDist, curr[2]});
        }
    }
}
