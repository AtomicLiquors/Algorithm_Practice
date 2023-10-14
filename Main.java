import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
           sum[i] = sum[i-1] + (arr[i] < arr[i-1] ? 1 : 0);
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write((sum[end] - sum[start]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
