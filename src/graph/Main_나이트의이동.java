import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_나이트의이동 {
	
	static int L;
	static int cnt;
	static int endR, endC;
	static int[][] map; //0 idx
	
	static int[] dR = {1, -1, 2, -2, 2, -2, 1, -1};
	static int[] dC = {-2, -2, -1, -1, 1, 1, 2, 2};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;
			L = sc.nextInt();
			map = new int[L][L];
			
			int startR = sc.nextInt();
			int startC = sc.nextInt();
			map[startR][startC] = -1;
			
			endR = sc.nextInt();
			endC = sc.nextInt();
			
			bfs(startR, startC, 0);
					
		}
	}
	
	static void bfs(int startR, int startC, int moves) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {startR, startC, moves});
		
		int nextR, nextC, curr[];
		
		while(!q.isEmpty()) {
			 curr = q.poll();
			 if(curr[0] == endR && curr[1] == endC) {
				 System.out.println(curr[2]);
				 return;
			 }
			 
			 for (int dir = 0; dir < 8; dir++) {
				 nextR = curr[0] + dR[dir];
				 nextC = curr[1] + dC[dir];
				 if(nextR >= 0 && nextC >= 0 && nextR < L && nextC < L && map[nextR][nextC]==0) {
					 map[nextR][nextC] = curr[2]+1;
					 q.offer(new int[]{nextR, nextC, curr[2]+1});
				 }
			}
			 
		}
	}
}



