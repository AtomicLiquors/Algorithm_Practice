import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node implements Comparable<Node>{
	
	int x;
	int y;
	
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Node o) {
		if(o.x == this.x) {
			return this.y - o.y;
		}else {
			return this.x - o.x;
		}
	}
}
public class Main_좌표정렬 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		StringTokenizer st;
		int x, y;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			pq.offer(new Node(x, y));
		}
		
		StringBuilder sb;
		while(!pq.isEmpty()) {
			sb = new StringBuilder();
			Node curr = pq.poll();
			sb.append(curr.x).append(" ").append(curr.y);
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();
		}

	}
	
}




