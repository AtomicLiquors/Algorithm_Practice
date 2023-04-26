package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_Centauri {

    static int goal;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            goal = Integer.parseInt(st.nextToken()) - 1;
            visited = new int[goal+1];

            bfs(start, 0);

        }
    }

    static void bfs(int pos, int dist){

        Queue<int[]> q = new ArrayDeque<>();
        visited[dist] = 1;
        q.offer(new int[]{pos, dist});
        int nextPos, nextDist;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            System.out.println(Arrays.toString(visited));
            if(curr[0]==goal){
                System.out.println(visited[curr[0]]-1);
                return;
            }

            nextDist = curr[1] + 1;
            nextPos = curr[0] + nextDist;
            //System.out.println(nextPos);
            //System.out.println(nextDist);

            if(nextPos <= goal && visited[nextPos] == 0){
                q.offer(new int[]{nextPos, nextDist});
                visited[nextPos] = visited[curr[0]] + 1;
            }


            nextPos--;
            nextDist--;
            if(nextPos <= goal && nextDist > 0 && visited[nextPos] == 0){
                q.offer(new int[]{nextPos, nextDist});
                visited[nextPos] = visited[curr[0]] + 1;
            }

            nextPos--;
            nextDist--;
            if(nextPos <= goal && nextDist > 0 && visited[nextPos] == 0){
                q.offer(new int[]{nextPos, nextDist});
                visited[nextPos] = visited[curr[0]] + 1;
            }
        }
    }
}
