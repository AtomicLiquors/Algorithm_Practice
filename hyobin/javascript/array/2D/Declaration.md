## 이차원 배열 선언
```javascript
//[x]
const acc = new Array(6).fill(new Array(6).fill(0));
//[o]
const acc = Array.from({ length: 6 }, () => new Array(6).fill(0));
```

Q. 다음과 같이 배열을 선언한 결과는 어떻게 될까?
```javascript
const acc = new Array(6).fill(new Array(6).fill(0));
acc[3][0] = -5;
return acc;
```
  
정답 : 
```
[
  [-5, 0, 0, 0, 0, 0],
  [-5, 0, 0, 0, 0, 0],
  [-5, 0, 0, 0, 0, 0],
  [-5, 0, 0, 0, 0, 0],
  [-5, 0, 0, 0, 0, 0],
  [-5, 0, 0, 0, 0, 0]
]
``` 
예상과 달리 3번 인덱스에 해당하는 행뿐만 아니라 모든 행에 값이 추가되었다.  
**acc의 각 행이 *new Array(6).fill(0)*로 생성된 단 하나의 배열**을 가리키고 있기 때문이다.

