package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3190_뱀 {
	// Z_ETC.Main_3190_뱀

	static int[] dR = { 0, 1, 0, -1 };
	static int[] dC = { 1, 0, -1, 0 };

	static int[][] board;
	static int N;
	static boolean over;

	static int dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		board = new int[N + 1][N + 1];

		StringTokenizer st;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;

		}

		int L = Integer.parseInt(br.readLine());

		
		int r = 1, c = 1;
		int[] tail;

		dir = 0;
		over = false;
		int elapsed = 0;

		Queue<int[]> snake = new ArrayDeque<>();
		snake.offer(new int[] { r, c });
		board[r][c] = -1;

		

		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		char cmd = st.nextToken().charAt(0);

		while (!over) {
			
			r += dR[dir];
			c += dC[dir];

			++elapsed;
			if (over = isOuttaBound(r, c))
				break;

			if (board[r][c] == 1) {
				snake.offer(new int[] { r, c });
				board[r][c] = -1;
			} else if (board[r][c] == 0) {
				snake.offer(new int[] { r, c });
				board[r][c] = -1;

				tail = snake.poll();
				board[tail[0]][tail[1]] = 0;

			} else if (board[r][c] == -1) {
				over = true;
				break;
			}
			
			if (elapsed == X) {
				redirect(cmd);
				//방향 조정
				
				//System.out.println(elapsed + " " + X + " " + cmd );
				
				if(--L > 0) {
					st = new StringTokenizer(br.readLine());
					X = Integer.parseInt(st.nextToken());
					cmd = st.nextToken().charAt(0);
				}else X = -1;
				
				
			}

		}

		System.out.println(elapsed);

	}

	static boolean isOuttaBound(int r, int c) {
		if (r < 1 || c < 1 || r > N || c > N)
			return true;
		return false;
	}

	static void redirect(char cmd) {
		switch (cmd) {
		case 'L':
			dir = (dir + 3) % 4;
			break;

		case 'D':
			dir = (dir + 1) % 4;
			break;
		}
	}

}
