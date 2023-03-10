import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_R835_C_Advantage {
    public static void main(String[] args) throws IOException {
        //System.out.println(Math.max(Integer.MAX_VALUE,2 * (long) Math.pow(10, 5)));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] strArr = new int[N];
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });


            for (int j = 0; j < N; j++) {
                int str = Integer.parseInt(st.nextToken());
                pq.add(new int[] {j, str});
                strArr[j] = str;
            }

            int[] curr = pq.poll();
            int firstIdx = curr[0];
            int firstStr = curr[1];
            int secondStr = pq.poll()[1];

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < N; j++) {
                if(j==firstIdx) sb.append(firstStr - secondStr).append(" ");
                else sb.append(strArr[j] - firstStr).append(" ");
            }

            System.out.println(sb);
        }
    }
}
