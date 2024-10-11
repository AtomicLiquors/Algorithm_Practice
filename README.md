# Algorithm_Practice

알고리즘 학습내역을 올리는 저장소


  

**문제별 권장 기록사항**

- [ ] 소요시간은? 성능은?
- [ ] **왜 틀렸는가? 무슨 실수를 했나?**
- [ ] 문제에서 간과한 점은? (출력 문제, 데이터 크기, 제약조건 등등)
- [ ] 코너 케이스
- [ ] "불가능한 경우" 찾기
  

- [매개변수 전달이 아닌, 3차원 DP 테이블 선언](https://github.com/TPA-ThreeProblemsAday/TPA_KBK/blob/main/BOJ/dp/BOJ14722.java)

- [배열을 쓰지 않는 '제거'](https://western-sky.tistory.com/135)
  
<br>
  
### 불가능한 경우
- [BOJ 1173](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/simulation/Main_1173.java)
- [BOJ 1103 : 무한 루프](https://loosie.tistory.com/250)

<br>

### 시간 초과
- 원소 갯수가 많다면 투 포인터 또는 [이분 탐색](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/binarysearch)을 의심해 봐라.
- [Stack을 활용한 탐색 속도 단축하기](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/stack#stack%EC%9C%BC%EB%A1%9C-%ED%83%90%EC%83%89-%EC%86%8D%EB%8F%84-%EB%8B%A8%EC%B6%95%ED%95%98%EA%B8%B0)

<br>

### 틀렸습니다 : 히든 테스트 케이스에 걸렸을 때
#### 정수 오버플로우
- [백준 1629](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/recursive/Main_1629.java)
- [[코너 케이스] 런타임 에러 : long만큼 긴 문자열을 int로 파싱](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java)

<br>


#### 경곗값


#### 기타
[백준 1009 분산처리](https://www.acmicpc.net/problem/1009)

### 목차
- [Map](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/Map.md)
- [수학](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics)
- [배열](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/array)
- [Comparator | Comparable](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/comparator)
- [비트마스킹](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/bitmasking)
- [시뮬레이션](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/simulation)
- [DP](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/DP)
- [Regex](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/regex)
- [문자열 탐색](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/stringSearching)

<br>

### List
- List의 수정 메서드는 add(idx, elem)가 아니라 set(idx, elem)이다.
  - add는 기존 항목을 수정하는 게 아니라 idx 자리에 항목을 하나 추가한다.
  - [BOJ 2504](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/stack/Main_2504.java)

- 원소 개수를 예측할 수 있으면 무작정 리스트를 쓰는 것보다 배열이 더 빠르다.
  ```
   예) N개의 원소로부터 nC2개의 조합을 만드는 경우 원소의 개수는 N(N-1)/2.
  ```
- 리스트 정렬
  ```java
  Collections.sort(list, ((o1, o2) -> (o2.stone - o1.stone)));
  ```

<br>

### 영역의 크기 구하기
- BFS를 돌리면서 좌표를 별도의 Queue에 담았다가, while문 종료 후 갯수를 배열에 저장.
- Map, Set을 활용하는 풀이도 참고바람.
  [프로그래머스 석유 시추](https://school.programmers.co.kr/learn/courses/30/lessons/250136)

<br>

### BFS도 DP도 아닌, 규칙 찾기 문제
  - [1](https://st-lab.tistory.com/79)
  - [2](https://www.acmicpc.net/problem/2292)

<br>

### [추가 시간 없음] 
백준 제한 시간은 c++기준이고 Java는 2x+1, Python은 3x+2 정도 가중치가 붙는다.
추가시간이 없다면 그냥 얄짤없이 써 있는 시간대로 풀어야 되고,
시간복잡도를 고민해봐야 된다는 것.

<br>

### 깡 반복문 문제
  - [1](https://school.programmers.co.kr/learn/courses/30/lessons/340198)
