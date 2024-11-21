### About
- 집합의 원소들을 $_nC_0$부터 $_nC_n$까지 모두 뽑는 알고리즘.
- 공집합이 포함되는 점에 유의하기 바란다.

<br>

### 코드
[유사 코드](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/subset/examples/SubsetPseudo.md)
[부분집합 기본](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/subset/examples/SubsetStandard.java)
[N개 중 최대 M개까지](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/subset/examples/SubsetLimited.java)

<br>

### 문제해결
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/combinatorics/subset/Troubleshooting.md)

<br>

### 개념
#### n개의 원소에 대해 부분집합 개수는 몇 개인가요?
$2^n$개 (공집합 포함)  
각 원소를 포함하거나, 포함시키지 않는 2가지 경우의 수를 모든 원소에 적용한 것과 같습니다.

<br>

#### n개의 원소에 대한 부분집합 중, 가장 원소가 많은 것은 무엇인가요?
$`_nC_{n/2}`$  
따라서 가장 느린 부분집합 알고리즘이 됩니다.

<br>

#### Power Set의 의미는 무엇인가요?
“모든 부분집합”
