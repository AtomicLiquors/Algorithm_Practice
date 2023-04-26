import java.util.Arrays;
import java.util.Scanner;

public class Main_2294_동전2_최효빈 {
	//시간 초과
	static int[] memo;
	static int[] numbers;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		numbers = new int[N];
		memo = new int[K+1];
		
		//Arrays.sort(numbers); //예상 반례 1: 동전의 가치가 크기순으로 주어지지 않을 경우, 작은 동전과 조합이 가능한데도 -1이 출력되는 경우를 예방함. 
		//-> 이거랑 상관없다. 어차피 재귀호출하면서 채워지게 돼 있다.
		
		Arrays.fill(memo, -1);
		
		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		
		memo[0] = 0; 
		
		int result = dp(K);
		
		System.out.println(result);
	}
	
	static int dp(int k) {
		
		if(memo[k] == -1) {
			int min = Integer.MAX_VALUE;
			for (int coin : numbers) {
				System.out.println("coin : " +coin);
				if(k >= coin) {
					int curr = dp(k-coin);
					if(curr != -1) {
						min = Math.min(curr + 1, min);
					}
					
					memo[k] = min==Integer.MAX_VALUE? -1: min;
				}
				//시간 초과.
			}
		}

		return memo[k];
	}
}
