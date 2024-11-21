### 넥스트 순열
“현 순열에서 사전순으로 다음 순열 생성”  
재귀를 사용하지 않으며, 원소 중복체크도 하지 않아 속도가 많이 빠르다!


쓰면 좋을 때 : nPn 구하기, 다음 번째 순열 구하기  
쓰면 안 될 때 : nPr을 구해야 할 때

### 과정
- 배열을 오름차순 정렬한 후 시작한다.
- 아래 과정을 반복하여, 사전 순으로, 다음으로 큰 순열 생성
    1. 뒤쪽부터 탐색하며 교환위치 (i-1) 찾기 (i : 꼭대기)
    2. 뒤쪽부터 탐색하며 (i - 1)와 교환할 큰 값 위치 (j) 찾기
    3. 두 위치 값 교환
    4. 꼭대기위치부터 맨 뒤까지 오름차순 정렬
- 가장 큰 내림차순 순열을 만들면 종료

<br>

### 코드
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/permutation/examples/PermutationNext.java)

### 주의사항
“NextPermutation 사용 전 숫자배열을 오름차순 정렬하여 가장 작은 순열 한번 처리하기” ← 의미가?

<br>

### 다음 순열 하나만 찾기
Arrays sort 떼고, dowhile 없이 np 1번만 실행

### 조합 찾기
[코드](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/combination/examples/CominationNP.java)

앞에서 만든 nextPermutation 코드를 수정할 필요가 없다.

- 원소 크기와 같은 크기의 int 배열 P를 생성하여
r개 크기만큼 뒤에서 0이 아닌 값으로 초기화한다.

- nextPermutation 알고리즘 활용 : 
한 번 수행시마다 조합이 만들어진다.
**한 번 수행시마다 0이 아닌 값의 위치가 변경된다.**
- P 배열에서 0이 아닌 값을 가진 위치에 해당하는 원소가 조합에 선택된 것.

#
