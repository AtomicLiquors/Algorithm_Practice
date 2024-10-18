## 틀렸습니다 : 히든 테스트 케이스에 걸린 경우


#### 정수 오버플로우
- [백준 1629](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/recursive/Main_1629.java)
- [[코너 케이스] 런타임 에러 : long만큼 긴 문자열을 int로 파싱](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java)

<br>

#### 반복문 내부에서 반복자 값을 수정한 경우
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
