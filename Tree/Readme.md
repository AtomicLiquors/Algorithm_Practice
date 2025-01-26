### tree

- [트리의 지름](https://www.acmicpc.net/problem/1167) : 트리의 특성을 생각하면 O(N)으로 구할 수 있다.  
    [풀이 링크](https://moonsbeen.tistory.com/101)
  1. 아무 노드에서 출발해서 가장 먼 노드를 하나 찾는다.
  2. 그 노드에서 가장 먼 노드까지의 거리가 정답이다.
  3. 유의사항 : 
     - 입력 시 연결 관계를 나타내는 간선은 중복해서 나타날 수 있다.
     - ([1] -> [3] 간선이 나온 뒤 [3] -> [1] 간선이 또 나올 수 있다. 이 경우 무한루프에 걸린다.)


- Tree 구현 시 부모 트리를 속성에 집어넣는다.

```java
public class Tree{
  int value;
  HashMap<String, Node> children;
  Node parent;
}
```

자세한 구현 예시는 추가바람.
