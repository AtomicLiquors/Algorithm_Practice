### 두 개의 백트래킹

[PCCP 기출 : 수레 움직이기](https://school.programmers.co.kr/learn/courses/30/lessons/250134)  
Q. 한 쪽이 목적지에 도달해서 더 이상 움직이지 않아야 하면 어떡하죠?  
A. 나머지 하나에 대해서만 dfs를 진행해 준다. [(풀이)](https://driveitlikeyoustoleitt.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-PCCP-%EA%B8%B0%EC%B6%9C%EB%AC%B8%EC%A0%9C-4%EB%B2%88-%EC%88%98%EB%A0%88-%EC%9B%80%EC%A7%81%EC%9D%B4%EA%B8%B0?category=1155483)
  
Q. 이 문제를 BFS로 풀려면 어떻게 하죠?  
A. 두 개의 Visited 배열을 Queue에 같이 담는다. 문제의 메모리 한도가 널널해서 그렇게 해도 풀린다. [(풀이)](https://rladuddms.tistory.com/m/463)  
