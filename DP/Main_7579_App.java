package com.ssafy.jdbctest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7579_App {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] costs = new int[N+1];
		int[] memories = new int[N+1];
		
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			memories[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] D = new int[N+1][10001];
		
		for (int i = 1; i <= N; i++) {
			for (int c = 1; c <= 10000; c++) {
				if(costs[i] > c) {
					D[i][c] = D[i-1][c];
				}else {
					D[i][c] = 
							Math.max(D[i-1][c], D[i-1][c-costs[i]] + memories[i]);
				}
			}
		}
		
		
		for (int c = 1; c <= 10000; c++) {
			if(D[N][c] >= M ) {
				System.out.println(c);
				break;
			}
		}
		
		
	}
}
