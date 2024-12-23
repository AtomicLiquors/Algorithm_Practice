package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_7568 {

    private static class Mass {
        int id;
        int weight;
        int height;

        public Mass(int id, int weight, int height){
            this.id = id;
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];
        StringTokenizer st;
        Mass[] candidates = new Mass[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            candidates[i] = new Mass(i, weight, height);
        }

        for (int i = 0; i < N; i++) {

            int rank = 1;

            for (int j = 0; j < N; j++) {
                if(i == j)
                    continue;
                if(candidates[j].height > candidates[i].height && candidates[j].weight > candidates[i].weight)
                    rank++;
            }
            result[i] = rank;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(' ');
        }
        System.out.println(sb);
    }
}
