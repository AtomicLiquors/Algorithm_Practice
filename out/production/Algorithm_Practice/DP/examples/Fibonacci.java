import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		long D[] = new long[N+1];
		
		D[0] = 0;
		D[1] = 1;
		for (int i = 2; i < N+1; i++) {
			D[i] = D[i-1] + D[i-2];
		}
		
		System.out.println(D[N]);
	}

}
