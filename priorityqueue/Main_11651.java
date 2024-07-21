package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> {
                    int comparison = o1[1] - o2[1];
                    return comparison != 0 ? comparison : o1[0] - o2[0];
                }
        );

        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] curr = new int[2];
            curr[0] = Integer.parseInt(st.nextToken());
            curr[1] = Integer.parseInt(st.nextToken());
            pq.offer(curr);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            sb.append(curr[0]).append(' ').append(curr[1]).append('\n');
        }
        System.out.print(sb);

        br.close();
    }
}
