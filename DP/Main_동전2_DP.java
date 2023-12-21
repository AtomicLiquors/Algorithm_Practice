package DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_동전2_DP {

	static int N, K, D[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		D = new int[K + 1];

		Arrays.fill(D, 100001);

		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			if(coin <= K)
				D[coin] = 1;
		}

		for(int i = 1; i <= K; i++){
			for (int j = 0; j <= i/2; j++) {
				D[i] = Math.min(D[i], D[j] + D[i-j]);
			}
		}

		System.out.println(D[K] == 100001 ? -1 : D[K]);
	}
}
