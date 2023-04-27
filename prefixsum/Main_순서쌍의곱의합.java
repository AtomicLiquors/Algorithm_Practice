import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_순서쌍의곱의합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] input = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		
		long sum = 0;
		long result = 0;
		for (int i = 0; i < N-1; i++) {
			sum += input[i]; 
			result += sum * input[i+1];
		}
		
		System.out.println(result);
		
	}

}
