
### 중복순열
반복문 안에 이 코드 하나가 있냐 / 없냐로 순열/중복순열이 갈린다.
```java
if(isSelected[i])
  continue;
```

### 비트마스킹 순열
비트마스킹으로 순열을 생성한다.  
AND(&)로 비트 체크, OR (|) 로 비트 세팅  
각 비트 자리가 ‘선택, 방문’여부를 나타낸다.
[코드](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/permutation/examples/bitPermutation.java)



<br>

### Troubleshooting
int 배열을 이용하지 않고, 1, 2, 3, 4 순서가 항상 일정한 boolean 배열의 인덱스를 이용하려고 했다.  
그래서 같은 순열이 중복 출력되는 것처럼 나타났다.

<br>

### 개념
N개의 요소들에 대해서 n!개의 순열이 존재한다. 
