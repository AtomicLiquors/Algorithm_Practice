package Algorithm_Practice.samsung01;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main_여행가자 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		StringTokenizer st;
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if(Integer.parseInt(st.nextToken())==1) {
					union(i, j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int prev = 0;
		if(M>0) prev = Integer.parseInt(st.nextToken());
		int curr;
		for (int i = 1; i < M; i++) {
			curr = Integer.parseInt(st.nextToken());
			if(findSet(prev) != findSet(curr)) {
				System.out.println("NO");
				return;
			}
		}
		
		System.out.println("YES");
	}
	
	static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);		
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
}
