package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int curr;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            curr = Integer.parseInt(br.readLine());
            if(curr == 0 ){
                Integer max = pq.poll();
                System.out.println(max == null ? 0 : max);
            }else{
                pq.offer(curr);
            }
        }
    }
}
