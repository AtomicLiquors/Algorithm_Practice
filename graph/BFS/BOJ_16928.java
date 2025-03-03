package graph.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = N + M;

        final int GOAL = 100;

        int[] route = new int[101];
        boolean[] visited = new boolean[101];

        while(cnt-- > 0 ){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            route[from] = to;
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{1, 0});

        int answer = 0;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            int pos = curr[0];
            int dicesThrown = curr[1];

            if(pos == GOAL){
                answer = dicesThrown;
                break;
            }


            int newPos;
            for (int dice = 1; dice <= 6; dice++) {

                newPos = pos + dice;
                if(newPos > 100 || visited[newPos])
                    continue;

                visited[newPos] = true;

                if(route[newPos] > 0){
                    newPos = route[newPos];
                    visited[newPos] = true;
                }

                que.offer(new int[]{newPos, dicesThrown + 1});
            }
        }

        System.out.println(answer);
    }
}
