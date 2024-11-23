```
s : 시작 정점, A: 인접행렬, D 시작정점에서의 거리 배열,
V : 정점 집합, U : 선택된 정점 집합
Dijkstra(s, A, D)
		U = {s};

		FOR 모든 정점 v
				D[v] <- A[s][v]
				
		WHILE U != V // 모든 정점이 선택되기 전까지 계속 돌린다.
				D[w]가 최소인 정점 w in V-U를 선택
				U <- U union {w}
				FOR w에 인접한 모든 미방문 정점 v
							D[v] <- min(D[v], D[w] + A[w][v])
```
