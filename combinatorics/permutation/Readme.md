### 순열 응용
#### 중복순열
반복문 안에 이 코드 하나가 있냐 / 없냐로 순열/중복순열이 갈린다.
```java
if(isSelected[i])
  continue;
```

#### 비트마스킹 순열
비트마스킹으로 순열을 생성한다.  
AND(&)로 비트 체크, OR (|) 로 비트 세팅  
각 비트 자리가 ‘선택, 방문’여부를 나타낸다.  
[코드](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/permutation/examples/bitPermutation.java)


#### 넥스트 순열
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/permutation/NextPermutation.md)

#### Swapping 순열(보충요)
각 자리 수마다, 자신부터 맨 뒤까지의 수를 교환하는 원리
```java
for(i = start; i < N; i++){
		swap(input, start, i);
		permu(start+1);
		swap(input, i, start);
		//위 코드에서 갔다 와서 원상복귀하는 코드는? 맨 밑에 맞아?
		//재귀만 쓰는 건데 속도는 넥퍼랑 비등하다. "빠르니까 알아둬야 한다".
		//코드가 되게 짧은데 이해는 어렵. -> 손으로 스택 그려볼까?
}
```

<br>

### Troubleshooting
int 배열을 이용하지 않고, 1, 2, 3, 4 순서가 항상 일정한 boolean 배열의 인덱스를 이용하려고 했다.  
그래서 같은 순열이 중복 출력되는 것처럼 나타났다.

<br>

### 개념
N개의 요소들에 대해서 n!개의 순열이 존재한다. 
