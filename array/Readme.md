
### int 대신 Integer 배열 써서 배열 역순 정리
```java
Integer[] input = new Integer[N];
Arrays.sort(input, Collections.reverseOrder());
```
<br>
  
### 2차원 배열을 돌 때마다 4방탐색을 하는 경우  
열 탐색을 “체스판”처럼 2칸씩 뛰면서 할 수 있다.   
TPA 인구 이동 문제 참고
```java

```

<br>

### List를 Array로
```java
String[] arr = list.toArray(new String[0]);
```
[관련 문제](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/array/Main_20920.java)

<br>

### 2차원 배열 돌리기
시계방향 90도 기준
- r행은 N-1-r열이 된다.
- c열은 r행이 된다.
```java
for(int r=0; r<N; r++){
	for(int c=0; c<N; c++) tmp_arr[c][N-1-r] = arr[r][c];
}
```
