import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_기상청인턴신현수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		int max = Integer.MIN_VALUE;

		st = new StringTokenizer(br.readLine());
		
		arr[0] = 0;
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1]; 
		}

		for (int i = K; i <= N; i++) {
			max = Math.max(max, arr[i]-arr[i-K]);
		}
		System.out.println(max);
		
		
		
	}

}
