import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_리모컨_실패 {
	static int[] input;
	static int min = Integer.MAX_VALUE;
	static int len, M;
	
	static class Node {
		int value;
		int cnt;
		
		public Node(int value, int cnt) {
			super();
			this.value = value;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		//BFS, 단 BFS회차 끝날 때마다 min 갱신, min보다 큰 녀석은 회차 종료.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K= Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		input = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		if(K==100) {
			System.out.println(0);
			return;
		}
		
		Queue<Node> q = new ArrayDeque<>();
		min = Math.abs(K-100); //
		
		
		q.offer(new Node(K, 0));
		
		while(!q.isEmpty()) {
			Node curr = q.poll();
			if(curr.value == 100) {
				min = Math.min(min, curr.cnt);
			}else {
				int result = nextMove(curr.value);
				if(result == -1) {
					min = Math.min(min, curr.cnt+len);
				}else {
					int next = curr.value + result;
					if(next <= 500000 && curr.cnt < min)
						q.offer(new Node(next, curr.cnt + result));
					next = curr.value - result;
					if(next >= 0 && curr.cnt < min)
						q.offer(new Node(next, curr.cnt + result));
				}
			}
		}
		
		System.out.println(min);
	}
	
	static int nextMove(int N) {
		len = (int) Math.log10(N);
		for (int div = (int) Math.pow(10, len); div >= 1; div /= 10) {
			int target = (N/div) % 10;
			for (int i = 0; i < M; i++) {
				if(target==input[i]) return div;
			}
		}
		
		return -1;
	}
}
