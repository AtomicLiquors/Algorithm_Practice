## Standard
### 정답이 틀렸습니다.
- 중간에 visited 체크를 빼먹진 않았나요?
- [visited 체크의 위치는 pq에서 꺼낸 직후여야 합니다.](https://www.acmicpc.net/status?from_mine=1&problem_id=1753&user_id=gyqls234)

<br>

### 메모리 초과
- 인접 매트릭스를 인접 리스트로 변경해 보세요.

<br>

### 시간 초과
- [시작 정점이 하나뿐이라면, 다익스트라를 한 번만 돌려도 다른 정점까지 모든 최단 경로를 구할 수 있습니다.](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/SSP/Dijkstra/Main_1753.java)
- 다시 한 번... [visited 체크의 위치는 pq에서 꺼낸 직후여야 합니다.](https://www.acmicpc.net/status?from_mine=1&problem_id=1753&user_id=gyqls234)
