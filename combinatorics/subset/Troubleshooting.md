    // 실패 코드도 같이 써놓자. 다음에 봐도 이해가 되게.

### 처음부터 끝까지 한번 더 출력이 돼요.    
원소 0을 배제해놓고, cnt를 0부터 시작한 경우      
0이 포함된 집합의 부분집합이 만들어지고 0만 출력이 안 된 건데, 이게 처음부터 끝까지 두번 출력된것처럼 보인 것  

<br>    

### 각 부분집합이 두번씩 출력이 돼요.    
잘 보니 마지막 원소가 빠져있었고, 반복문 종료조건에 등호 추가

<br>

### 연산을 너무 많이 하는 것 같아요.
재귀함수 내부에서 반복문을 돌리지 않는다.  
cnt가 곧 인덱스다.
