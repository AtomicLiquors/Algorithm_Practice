```java
/***
start : 시작 정점, adjMatrix: 인접행렬, dist: 시작정점에서의 거리 배열,
vertices : 정점 집합, selected : 선택된 정점 집합
***/
Dijkstra(start, adjMatrix, dist)
	selected = {start};

	FOR 모든 정점 vertices
		dist[v] <- adjMatrix[start][v]
				
	WHILE selected != vertices // 모든 정점이 선택되기 전까지 계속 돌린다.
		dist[w]가 최소인 정점 w in vertices-selected를 선택
		selected <- selected union {w}
		FOR w에 인접한 모든 미방문 정점 v
			dist[v] <- min(dist[v], dist[w] + A[w][v])
```
