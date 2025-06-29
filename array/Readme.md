## 📁 배열 (Array)
배열 활용과 관련된 팁, 신택스 저장소

---


### 🔁 역순 정렬

기본형 `int[]`은 `Collections.reverseOrder()`를 사용할 수 없기 때문에,  
래퍼 타입을 사용한 `Integer[]`로 선언해야 역순 정렬이 가능하다.

```java
Integer[] input = new Integer[N];
Arrays.sort(input, Collections.reverseOrder());
```

---

### 🔍 2차원 배열에서 체스판처럼 탐색하기

2차원 배열을 탐색할 때, 열을 두 칸씩 건너뛰며 체스판처럼 순회하면 효율적이다.  
TPA 인구 이동 문제 참고.

---

### 🔄 리스트를 배열로 변환

`List<String>`을 `String[]`로 바꾸는 방법이다.

```java
String[] arr = list.toArray(new String[0]);
```

🔗 [관련 문제 (`Main_20920.java`)](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/array/Main_20920.java)

---

### 📊 계수 정렬 (Counting Sort)

등장 빈도를 기반으로 정렬하고 싶을 때 사용하는 방식이다.  
빈도수를 배열로 저장하고, 누적합을 활용해 정렬 순서를 만든다.

📝 [관련 블로그](https://st-lab.tistory.com/104)

---

### 🔁 사각형 배열 회전
#### 정사각형 배열 회전, 90도 시계 방향

정사각형 배열을 기준으로 90도 시계 방향으로 회전시키는 기본 로직이다.

```java
for (int r = 0; r < N; r++) {
    for (int c = 0; c < N; c++) {
        tmp_arr[c][N - 1 - r] = arr[r][c];
    }
}
```

---

#### 직사각형 배열 회전

직사각형 배열을 회전할 때는 별도의 로직이 필요하다.
자세한 구현은 아래 문제에서 확인할 수 있다.

📌 백준 16926번 - 배열 돌리기 1
🔗 [풀이 블로그](https://seen-young.tistory.com/127)

---

