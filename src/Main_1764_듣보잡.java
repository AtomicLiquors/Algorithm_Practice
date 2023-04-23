import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1764_듣보잡 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] unheard = new String[N];



        for (int i = 0; i < N; i++) {
            unheard[i] = br.readLine();
        }

        Arrays.sort(unheard);

        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            int n = Arrays.binarySearch(unheard, br.readLine());
            if(n >= 0) {
                cnt++;
                pq.offer(n);
            }
        }

        sb.append(cnt).append("\n");
        while(!pq.isEmpty()){
            sb.append(unheard[pq.poll()]).append("\n");
        }

        System.out.println(sb);


    }
}
