import java.util.Arrays;
import java.util.Scanner;

public class BinomialCoefTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[][] B = new int[N+1][K+1];
		
		for (int i = 0; i < B.length; i++) {
			for (int j = 0, end = Math.min(i, K); j <= end; j++) {
				if(j==0 || i==j) B[i][j] = 1;
				else B[i][j] = B[i-1][j-1] + B[i-1][j]; 
			}
		}
		
		for (int[] is : B) {			
			System.out.println(Arrays.toString(is));
		}
		System.out.println(B[N][K]);
		//재귀함수를 작성할 때는...
		//Flat한 시야와
		//"함수 정의를 명확히"하라고 했었는데,
		//이 '함수 정의를 명확히 하라는 것은 동적 계획법에서 "동적 테이블에 무엇을 저장할지"와 연관이 깊다.
	}

}
