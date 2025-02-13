package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int id = 1; id <= N; id++) {
            int value = Integer.parseInt(st.nextToken());
            deque.offer(new int[]{id, value});
        }

        StringBuilder sb = new StringBuilder();

        int[] curr = deque.poll();
        while(true){
            sb.append(curr[0]).append(' ');
            if(deque.isEmpty())
                break;

            int cmd = curr[1];
            if(cmd > 0){
                curr = deque.pollFirst();
                for (int i = 1; i < cmd; i++) {
                    deque.offerLast(curr);
                    curr = deque.pollFirst();
                }
            }else{
                curr = deque.pollLast();
                for (int i = -1; i > cmd; i--) {
                    deque.offerFirst(curr);
                    curr = deque.pollLast();
                }
            }
        }

        System.out.println(sb);
    }
}
