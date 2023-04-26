package DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_동전2_2nd {
	
	static int N, K, D[];
	static Integer input[];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		input = new Integer[N];
		D = new int[K+1];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if(input[i]==K) {
				System.out.println(1);
				return;
			}
		}
		
		Arrays.sort(input, Collections.reverseOrder());

		D[K] = 100001;

		dp(K);

		System.out.println(D[K]==100001?-1:D[K]);
	}

	static void dp(int n){
		for (int i = 0; i < N; i++) {
			if(n == input[i]){
				D[n] = 1;
				return;
			}else if(n < input[i]){
				continue;
			}else{
				D[n] = Math.min(D[input[i]] + D[n-input[i]], D[n]);
			}
		}
	}
}
