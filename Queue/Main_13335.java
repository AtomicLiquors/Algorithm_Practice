package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> waitingQueue = new ArrayDeque<>();
        Queue<Integer> crossingQueue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            waitingQueue.offer(Integer.parseInt(st.nextToken()));
        }

        for(int w = 0; w < W; w++){
            crossingQueue.offer(0);
        }

        int time = 0;

        int currentWeight = 0;

        while(!waitingQueue.isEmpty()){
            time++;

            int truck = waitingQueue.peek();
            currentWeight -= crossingQueue.poll();

            int next = 0;

            if(currentWeight + truck <= L){
                waitingQueue.poll();
                next = truck;
                currentWeight += truck;
            }

            crossingQueue.offer(next);

        }

        System.out.println(time + crossingQueue.size());
    }
}
