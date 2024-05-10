package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(st.hasMoreTokens()){
            pq.offer(Double.parseDouble(st.nextToken()));
        }

        double M = pq.poll();
        double sum = 1;

        while(!pq.isEmpty()){
            sum += (pq.poll() / M);
        }

        System.out.println(sum * 100 / N);
    }
}
