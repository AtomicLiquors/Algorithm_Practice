### 👨‍💻 About
큐 자료구조를 활용한 문제풀이 저장소

<br>

### Queue
큐의 사이즈로 for문을 돌리지 않는다.  
반복문 회차를 돌릴 때마다 큐 사이즈가 새로 측정된다.


```java
    // O
    int size = deque.size();
    int[] answer = new int[size];
    
    for(int i = 0; i < size; i++){
        answer[i] = deque.poll();
    }
```

```java
    // X
    int[] answer = new int[deque.size()];
    
    for(int i = 0; i < deque.size(); i++){
        answer[i] = deque.poll();
    }
```
[Queue가 특정 항목을 갖고 있는지는 .contains()로 찾아라.](https://loosie.tistory.com/416)
[숨바꼭질 3 DQ 활용 풀이법](https://www.acmicpc.net/source/87689417)
