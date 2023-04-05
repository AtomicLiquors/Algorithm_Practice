import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서_모범답안_dfs {
	
	static int N, M, cnt, adj[][], radj[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
			radj = new int[N+1][N+1];
			
			StringTokenizer st = null;
			int a, b;
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				radj[b][a] = adj[a][b] = 1; 
				// 유향이므로 [b][a]말고 [a][b]만
				
			}
			
			int answer = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				dfs(k, adj, new boolean[N+1]);
				dfs(k, radj, new boolean[N+1]);
				if(cnt == N-1) answer++; 
			}
			System.out.printf("#%d %d\n", tc, answer);
		}
	}
	
	static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i]==1 && !visited[i]) {
				cnt++;
				dfs(i, adj, visited);
			}
		}
	}
	
}


