# Algorithm_Practice

알고리즘 학습내역을 올리는 저장소


  

### **문제별 권장 기록사항**

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
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/Wrong_Answer.md)
<br>


### 목차
||
|------------|
|[Array](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/array)|
|[List](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/List.md)|
| [Queue](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/Queue/Readmd.md) |
| [Map](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/Map.md) |
| [수학](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics) |
| [Comparator \| Comparable](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/comparator) |
| [비트마스킹](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/bitmasking) |
| [시뮬레이션](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/simulation) |
| [DP](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/DP) |
| [Regex](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/regex) |
| [문자열 탐색](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/stringSearching) |
| [조합론(순열, 조합, 부분집합)](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/combinatorics) |
| [부분집합](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/combinatorics/subset) |
| [최소 신장 트리 : 모든 정점 연결](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/SpanningTree) |
| [최단 경로 알고리즘](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/SSP) |


<br>

<br>

### PriorityQueue Comparator 정의하기
```java
PriorityQueue<int[]> pq = new PriorityQueue<>(
    (a1, a2) -> a1[0] - a2[0]
);
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

<br>

### 커밋 컨벤션 (from '24.11.21)
| Rendered   | Code   | Content  |
|------------|------------|------------|
| 🚀 | rocket | SOLVED |
| 🔥 | fire | FAILED |
| :package: | package  | 패키지 구조 정리 및 기타 유지보수 |
| 📝 | memo | 문서 업데이트 |
👨‍💻 About
 
<br>

### "코테에서 문제 풀 땐, 제발 완전탐색부터 고민해보자!" 
완전탐색을 시도했을 때의 시간복잡도를 확인한 후 데이터의 크기를 살펴본다면,   
이 방법이 통과되는지 아닌지 쉽게 알 수 있을 것이다.

<br>

코테 문제 중에선 완탐으로 풀리는 문제를 그리디나, 다른 방법으로 풀리는 것 처럼 **눈속임하는 문제가 정말 많다.**   
이번 네이버 4번도 그러한 문제였는데, 바로 완탐부터 의심했으면 정말 쉽게 풀렸을 문제였다.  

<br>

### switch 범위 지정 : 10 단위로 
```java
switch( (int) score / 10 ) {
  case 0 :
      ...
      break;
  case 1 :
      ...
      break;
  case 2 :
      ...
      break;
}
```
<br>

### parseInt와 valueOf의 차이?
**parseInt()는 기본 int를 반환,** 
**valueOf()는 Integer 래퍼 객체를 반환**

<br>
 
### 다시 확인할 문제
[누적합, 대각선, DP](https://www.acmicpc.net/problem/11066)
