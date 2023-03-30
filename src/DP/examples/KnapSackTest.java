package com.ssafy.live24;

import java.util.Scanner;

public class KnapSackTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		int[] weights = new int[N + 1];
		int[] profits = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}

		int[][] D = new int[N + 1][W + 1];
		//초기 세팅 : int[][] 자동초기화
		
		
		for (int i = 1; i <= N; i++) { // i: 물건
			for (int w = 1; w <= W; w++) { // w: 가방 무게
				//해당 물건의 무게가 w를 초과하는지 검증한다.
				if(weights[i] > w) {
					D[i][w] = D[i-1][w];
					//직전의 최적해가 그대로 현재의 최적해가 된다.
				}else {
					//담을 수 있는 상황
					D[i][w] = Math.max(D[i-1][w], profits[i]+D[i-1][w-weights[i]]);
				}
			}
		}
		
		System.out.println(D[N][W]);
		
		
		sc.close();
	}

}
