package com.ssafy.jdbctest;

import java.util.Scanner;

public class Main_최대공최소공_trial {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if(N > M) {
			int temp = N;
			N = M;
			M = temp;
		}
		if(M%N==0) {
			System.out.println(N);
			System.out.println(M);
			return;
		}
	
		int max = 1;
		for (int i = 2; i <= N/2; i++) {
			if(N%i==0 && M%i==0)
			max = i;
		}
		
		
		System.out.println(max);
		System.out.println(max * (N/max) * (M/max));
		
	}
}
