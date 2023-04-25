import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;


class Node {
	int value;
	int cnt;
	
	public Node(int value, int cnt) {
		this.value = value;
		this.cnt = cnt;
	}
}

public class Main_동전2_메모리초과 {
	//깡 BFS로 풀었다.
	
	static int N, K;
	static Queue<Node> q = new ArrayDeque<>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		Integer[] input = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(br.readLine());
			if(input[i]==K) {
				System.out.println(1);
				return;
			}
		}
		
		Arrays.sort(input, Collections.reverseOrder());
		for (int i = 0; i < N; i++) {
			q.offer(new Node(input[i], 1));
		}
		
		while(!q.isEmpty()){
			Node curr = q.poll();
			
			for (int i = 0; i < N; i++) {
				int next = curr.value + input[i];
				if(next == K) {
					System.out.println(curr.cnt+1);
					return;
				}else if(next < K) {
					q.offer(new Node(next, curr.cnt+1));
				}
			}
		}
		System.out.println(-1);
	}
}
