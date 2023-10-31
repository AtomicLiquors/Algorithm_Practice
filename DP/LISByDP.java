package DP;

import java.util.Scanner;

public class LISByDP {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 0; // 최종 출력할 최댓값

		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // 임시값 : 자기 자신만 포함하는 경우.
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			if(max < LIS[i]) max = LIS[i];
		}
		System.out.println(max);
	}
}