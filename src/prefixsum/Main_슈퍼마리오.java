import java.util.Scanner;

public class Main_슈퍼마리오 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] sum = new int[11];
		sum[0] = 0;
		for (int i = 1; i <= 10; i++) {
			sum[i] = sc.nextInt() + sum[i-1];
			if(sum[i] >= 100) {
				int a = sum[i] - 100;
				int b = 100 - sum[i-1];
				System.out.println(a <= b? sum[i]: sum[i-1]);
				return;
			}
		}
	}

}
