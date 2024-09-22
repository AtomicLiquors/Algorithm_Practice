import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10989 {
    public static void main(String[] args) throws IOException {
        // PQ 사용 시 메모리 초과.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int num : arr){
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }
}
