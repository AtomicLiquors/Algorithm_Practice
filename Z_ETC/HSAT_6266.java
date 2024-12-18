package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HSAT_6266 {

    public static void main(String[] args) throws IOException {

        Map<String, boolean[]> map = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, new boolean[19]);
            pq.offer(name);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String room = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            boolean[] reservation = map.get(room);
            for (int j = s; j < t; j++) {
                reservation[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            String room = pq.poll();

            boolean[] reservation = map.get(room);

            sb.append("Room ").append(room).append(":\n");
            Queue<Integer> que = new ArrayDeque<>();
            int start = 9, end;
            while(start < 18){
                if(!reservation[start]){
                    end = start;

                    while(++end < 18 && !reservation[end]);

                    que.offer(start * 100 + end);
                    start = end+1;
                }else{
                    start++;
                }
            }

            if(que.isEmpty())
                sb.append("Not available\n");
            else{
                sb.append(que.size()).append(" available:\n");
                while(!que.isEmpty()){
                    int curr = que.poll();
                    sb.append(format2Digits(curr / 100))
                            .append('-')
                            .append(format2Digits(curr % 100))
                            .append('\n');
                }
            }
            if(pq.peek() != null)
                sb.append("-----\n");
        }

        System.out.print(sb);

        br.close();
    }

    static String format2Digits(int target){
        return String.format("%02d", target);
    }
}
