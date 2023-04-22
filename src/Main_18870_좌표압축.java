import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18870_좌표압축 {
    public static void main(String[] args) throws IOException {
        //long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        Arrays.sort(sorted);

        Map<Integer, Integer> result = new HashMap<>();


        for (int i = 0, j = 0; i < N; i++) {
            if(result.get(sorted[i])!=null) continue;
            result.put(sorted[i], j++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result.get(arr[i])).append(" ");
        }
        System.out.println(sb);

        //long end = System.currentTimeMillis();
        //System.out.println((end-start));

    }

}
