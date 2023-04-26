import java.util.Arrays;
import java.util.Scanner;

public class Main_1010_다리놓기 {
//Main_1010_다리 놓기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int result = 0;
			
			int K = sc.nextInt();
			int N = sc.nextInt();
			
			int[][] B = new int[N+1][K+1];
			
			for (int i = 0; i < B.length; i++) {
				for (int j = 0, end = Math.min(i, K); j <= end; j++) {
					if(j==0 || i==j) B[i][j] = 1;
					else B[i][j] = B[i-1][j-1] + B[i-1][j]; 
				}
			}
			
			
			System.out.println(B[N][K]);
			
		}
		//이차원 배열 메모이제이션으로 효과적인 조합 구하기.
		//
	}

}
