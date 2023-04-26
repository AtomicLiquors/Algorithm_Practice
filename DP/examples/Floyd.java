package DP.examples;

import java.util.Scanner;

/**
 * @author taeheekim
 */
// 양의 가중치 버전
public class Floyd {

	static final int INF = 9999999;
	static int N,distance[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		distance = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				distance[i][j] = sc.nextInt();
				if(i != j && distance[i][j]==0) {//자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
					distance[i][j]=INF;
				}
			}
		}
		System.out.println("===========입력==========");
		print();
        // 출발지-->경유지-->목적지로 3중 루프 돌리면 오답
        // 경유지-->출발지-->목적지로 3중 루프 돌려야 정답
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; // 출발지와 경유지가 같다면 다음 출발지
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; 
					// 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
					// 없으면 이런 값들이 if문을 통해서 들어오긴 하겠지만... 이런 경우 D[i][j]가 0이라 아래 조건문을 통과해도 아무 일도 일어나지 않는다.
					// 단 회차마다 불필요한 연산이 늘어난다. 
					if(distance[i][j] > distance[i][k]+distance[k][j]) {
					//if(distance[i][k] != INF && distance[k][j] != INF && distance[i][j] > distance[i][k]+distance[k][j]) {
					//굳이 굳이 음의 가중치까지 품겠다면 이렇게 하면 되는데 '삼중 포문'안에서 이렇게 연산이 늘어나는 건 치명적.
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
			print();
		}
	
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(distance[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}
