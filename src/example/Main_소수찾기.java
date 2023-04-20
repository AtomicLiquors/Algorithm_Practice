package com.ssafy.jdbctest;

import java.util.Scanner;

public class Main_소수찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = 0;
		
		int target;
		for (int i = 0; i < N; i++) {
			target = sc.nextInt();
			if(isPrime(target)) cnt++;
		}
		System.out.println(cnt);
	}
	
	static boolean isPrime(int num) {
		if(num==1) 
			return false;
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if(num%i == 0) return false;
			//if(i * (num/i) == num) return false;
		}
		return true;
	}
}
