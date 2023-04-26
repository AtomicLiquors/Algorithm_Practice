import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070_파이프옮기기1_최효빈 {
	static int N;
	static int[][] map;
	static int cnt=0;
	
	static int[] dR = {1, 1, 0};
	static int[] dC = {0, 1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+1][N+1];
		StringTokenizer st;
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(1, 2, 2);
		System.out.println(cnt);
	}
	
	static boolean isWall(int r, int c) {
		if(r>N || c>N) {
			//			System.out.println("outta bound");
			return true;
		}
		
		if(map[r][c]==1) {
			//			System.out.println("encountered 1");
			return true;
		}

		return false;
	}
	
	static void dfs(int r, int c, int dir) {
		
		if(r==N && c==N) {
			cnt++;
			return;
		}
		
		
		
		//System.out.println(r + " " + c + " dir: " + dir);
		
		boolean flag0 = !isWall(r + dR[0], c + dC[0]);
		boolean flag2 = !isWall(r + dR[2], c + dC[2]);
		boolean flag1 = !isWall(r + dR[1], c + dC[1]);

		if(flag0) {
			if(dir!=2) dfs(r + dR[0], c + dC[0], 0);
		}
		
		if(flag2) {
			if(dir!=0) dfs(r + dR[2], c + dC[2], 2);
		}
			
		if(flag0 && flag2 && flag1) {
			dfs(r + dR[1], c + dC[1], 1);
		}
				
		
	}
	
}
