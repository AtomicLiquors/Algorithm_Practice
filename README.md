# Algorithm_Practice

알고리즘 학습내역을 올리는 저장소


  

**문제별 권장 기록사항**

- [ ] 소요시간은? 성능은?
- [ ] **왜 틀렸는가? 무슨 실수를 했나?**
- [ ] 문제에서 간과한 점은? (출력 문제, 데이터 크기, 제약조건 등등)
- [ ] 코너 케이스
- [ ] "불가능한 경우" 찾기
  

- [Map - getOrDefault()](https://gymdev.tistory.com/39)
  - 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본 값을 반환하는 메서드
- [Map의 Key들을 이용해 리스트 만들기]
   ```List<Integer> list = new ArrayList<>(map.keySet())```

- [매개변수 전달이 아닌, 3차원 DP 테이블 선언](https://github.com/TPA-ThreeProblemsAday/TPA_KBK/blob/main/BOJ/dp/BOJ14722.java)
- [BFS도 DP도 아닌, 규칙 찾기 문제](https://st-lab.tistory.com/79)
- [배열을 쓰지 않는 '제거'](https://western-sky.tistory.com/135)

### 수학
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics)
  
### 불가능한 경우
- [BOJ 1173](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/simulation/Main_1173.java)
- [BOJ 1103 : 무한 루프](https://loosie.tistory.com/250)

### 배열
- [링크 요망](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/array)

### Comparator | Comparable
- 링크 요망

### List의 수정 메서드는 add(idx, elem)가 아니라 set(idx, elem)이다.
add는 기존 항목을 수정하는 게 아니라 idx 자리에 항목을 하나 추가한다.
- [BOJ 2504](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/stack/Main_2504.java)

### 배열 문제의 시간 초과
투 포인터 또는 이분 탐색을 의심해 봐라.

### 비트마스킹
- 링크 요망

### Knapsack은 입력과 동시에 풀 수 있다
- TPA 호텔 문제 참조바람

### Map과 Set으로 시뮬레이션 최적화
[simulation > Main_16946_GPT](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/simulation/Main_16946_GPT.java)

### Flood Fill 형태라면 BFS가 더 유리하다.
"BFS is generally more efficient for this kind of problem because it avoids deep recursion and can be implemented iteratively with a queue."
