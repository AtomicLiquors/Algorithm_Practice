package SSP.Dijkstra.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class DijkstraPQ {

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
		Arrays.fill(distance, INF);
		boolean[] visited = new boolean[V];

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {노드, 거리}
		pq.offer(new int[]{start, 0});
		distance[start] = 0;

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int curNode = current[0];
			int curDist = current[1];

			if (visited[curNode]) continue;
			visited[curNode] = true;

			for (int next = 0; next < V; next++) {
				if (adjMatrix[curNode][next] != 0 && distance[next] > curDist + adjMatrix[curNode][next]) {
					distance[next] = curDist + adjMatrix[curNode][next];
					pq.offer(new int[]{next, distance[next]});
				}
			}
		}
		
		System.out.println(distance[end]!=INF? distance[end]: -1);
		
	}

}
