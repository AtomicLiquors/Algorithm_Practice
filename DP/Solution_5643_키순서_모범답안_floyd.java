import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5643_키순서_모범답안_floyd {
	
	static int N, M, adj[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N+1][N+1];
						
			StringTokenizer st = null;
			int a, b;
			for(int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; 
				// 유향이므로 [b][a]말고 [a][b]만
				
			}
			
			for (int k = 1; k <= N; k++) { //경유(학생 k)
				for (int i = 1; i <= N; i++) { //출발(학생 i)
					if(i==k || adj[i][k]==0) continue; //경유효과 없음(알 수 있는 관계 없음)
					for (int j = 1; j <= N; j++) { //도착(학생 j)
						// i < k < j
						if(adj[i][j]==1) continue;
						adj[i][j] = adj[k][j];
					}
				}
			}
			
			int answer = 0;
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[i][0] += adj[i][j];
					adj[0][j] += adj[i][j];
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) ++answer;
			}
			
			System.out.printf("#%d %d\n", tc, answer);
		}
	}

    public static class Main_동전1 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] coins = new int[N+1];
            int[] D = new int[K+1];
            D[0] = 1;

            for (int i = 1; i <= N; i++) {
                coins[i] = Integer.parseInt(br.readLine());
            }

            for(int i = 1; i <= N; i++){
                for (int j = coins[i]; j <= K; j++) {
                    D[j] += D[j - coins[i]];
                }
            }

            System.out.println(D[K]);
        }
    }
}


