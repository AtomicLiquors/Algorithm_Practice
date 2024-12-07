

### Flood Fill 형태라면 BFS가 더 유리하다.
"BFS is generally more efficient for this kind of problem because it avoids deep recursion and can be implemented iteratively with a queue."

<br>

### 외곽선 탐색 시 주의사항
![BFS OUTLINE](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/simulation/BFS_OUTLINE.PNG)

<br>

### 4차원 Boolean 배열
[문제 링크](https://www.acmicpc.net/problem/13460)  
[풀이 링크](https://minhamina.tistory.com/191)  

<br>

### 2차원 배열에서 dfs depth가 3 이하라면
visited 배열을 사용하는 대신,  
직전 x, y좌표만 dfs 함수에 매개변수에 전달해 줘도  
무한루프를 방지할 수 있다.  
[링크](https://velog.io/@christer10/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14500-%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8)

<br>

### 2가지 이상의 탐색 함수가 필요한 경우도 있다.
[링크](https://velog.io/@christer10/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-14500-%ED%85%8C%ED%8A%B8%EB%A1%9C%EB%AF%B8%EB%85%B8)
