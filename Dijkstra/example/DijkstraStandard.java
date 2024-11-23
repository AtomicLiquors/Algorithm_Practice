package Dijkstra.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraStandard {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V]; 
		//정점 개수만큼 distance 배열 생성 : 출발지점에서 자신까지 오는 비용.
		boolean[] visited = new boolean[V]; //경유지로 고려된 정점여부
		
		Arrays.fill(distance, INF); //최솟값 갱신 로직을 반영해야 하므로, 큰 값으로 초기화
		distance[start] = 0;
		
		int min, current;
		for (int c = 0; c < V; c++) {
			
			//1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current = -1;
			min = INF;
			
			for (int i = 0; i < V; i++) {
				if(!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current == -1) break;
				// 아무것도 선택되지 않았다면 break.
			visited[current] = true;
				// 무언가 하나 선택되었다면 visited 체크.
			
				// 응용 : 선택 정점이 문제에서 요구하는 도착 정점이면 끝내기
			if(current == end) break;
			
			//2 : 다른 미방문 인접 정점에 대해, 위에서 선택된 정점을 경유한 경우를 반영하여 비용 최솟값 갱신
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
					distance[j] = min + adjMatrix[current][j];
					// 마지막 조건문 대신 Math.min으로 대체할 수 있지 않을까?
				}
			}
		}
		
		System.out.println(distance[end]!=INF? distance[end]: -1);
		
	}

}
