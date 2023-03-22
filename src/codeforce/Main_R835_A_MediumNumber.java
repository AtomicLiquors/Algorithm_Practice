import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_R835_A_MediumNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Integer> pq;
        for (int i = 0; i < T; i++) {
            pq = new PriorityQueue<Integer>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++)
                pq.add(Integer.parseInt(st.nextToken()));

            pq.poll();
            System.out.println(pq.poll());
        }

    }
}
