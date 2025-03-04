## 틀렸습니다 : 히든 테스트 케이스에 걸린 경우


#### 정수 오버플로우
- [백준 1629](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/recursive/Main_1629.java)
- [백준 8595](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_8595.java)
- [[코너 케이스] 런타임 에러 : long만큼 긴 문자열을 int로 파싱](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java)
- [입력값은 정수 범위일지라도, 정답은 정수 범위를 초과할 수 있다](https://velog.io/@skyepodium/%EB%B0%B1%EC%A4%80-13458-%EC%8B%9C%ED%97%98-%EA%B0%90%EB%8F%85)
- 모듈러 분배 법칙(추가바람)

<br>


### 시작 인덱스 설정을 잘못 한 경우
```java
static boolean test(String input, int start, int end){
        // end is exclusive

        if(end - start <= 1)
            return true;

        int mid = (start + end) / 2;

        // (x)
        for (int i = 0; i < mid; i++) {
            // ...
        }

        // (o)
        for (int i = start; i < mid; i++) {
            // ...
        }

```

<br>

#### 바뀐 변수 값 재사용
**1. 반복문 내부에서 반복자 값을 수정한 경우**
```java
// Before
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int row = 1; row <= Math.sqrt(yellow); row++){
            if(yellow % row != 0)
                continue;
            
            int col = yellow / row;
            
            if(2 * ( (row += 2) + (col += 2) - 2) == brown){
                // 여기서 row 자체를 2씩 증가시켜 버리기 때문에 반복문이 1이 아니라 3 간격으로 건너뛰게 된다.
                // 딴에 연산 중복을 줄인다고 한 거지만, 중복이 일어나는 건 어차피 정답을 찾았을 때 단 한번 뿐이므로 큰 의미가 없다.
                answer[0] = col;
                answer[1] = row;
                break;
            }
        }
        
        return answer;
    }
}
```

```java
// After
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for(int row = 1; row <= Math.sqrt(yellow); row++){
            if(yellow % row != 0)
                continue;
            
            int col = yellow / row;
            
            if(2 * ( (row + 2) + (col + 2) - 2) == brown){
                answer[0] = col + 2;
                answer[1] = row + 2;
                break;
            }
        }
        
        return answer;
    }
}
```

<br>

**2.행렬 곱셈**
```java
long na = multiplyRowAndColum(a, b, a, c);
        long nb = multiplyRowAndColum(a, b, b, d);
        long nc = multiplyRowAndColum(c, d, a, c);
        long nd = multiplyRowAndColum(c, d, b, d);

        if(N.mod(TWO).equals(BigInteger.ONE)){
            na = multiplyRowAndColum(na, nb, 1, 1);
            nb = multiplyRowAndColum(na, nb, 1, 0); // 직전 라인에서 바뀐 na값을 재사용하고 있다.
            nc = multiplyRowAndColum(nc, nd, 1, 1);
            nd = multiplyRowAndColum(nc, nd, 1, 0); // 여기도 마찬가지
        }

        return new long[][]{
            {na, nb},
            {nc, nd}
        };
```

<br>

#### 경곗값

<br>

#### N이 0으로 주어졌을 때
[백준 18110 solved.ac](https://www.acmicpc.net/problem/18110)

<br>

#### 기타
[백준 1009 분산처리](https://www.acmicpc.net/problem/1009)  
[백준 16976 배열 복원하기](https://www.acmicpc.net/problem/16967)  
테스트 케이스 배열의 크기를 늘렸을 때 반례를 발견할 수 있었다.  
