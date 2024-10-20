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
