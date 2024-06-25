### ⚠️ 실제 코드는 인라인으로 작성하지 말 것! ⚠️ 
프로그래머스 추천 답안은 JS 내장 메서드의 응용 감각을 기르는 것뿐,
성능이나 유지보수성 면에서 권장할 코드가 아니다.

### Tip
- Number()대신 +연산자 사용하기.
```
// before
stringifiedNumbers.filter(string => isPrime(Number(string)).length
// after
stringifiedNumbers.filter(string => isPrime(+string)).length
```

### 신택스
- [올바른 이차원 배열 선언](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/array/2D/Declaration.md)
  
### 정렬
- [.sort()로 숫자 정렬](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/sort/Programmers_42576.js)
- [두 개의 정렬 조건식](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/sort/programmers_120880.js)
- [... 연산자로 문자열 -> 배열 만들기](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/string/Programmers_120911.js)

### 소인수분해
- [소인수 종류별로 구하기](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/tree/main/hyobin/javascript/prime)

### 아스키 코드
- [문자에서 아스키 코드 구하기, 문자로 되돌리기](https://github.com/AtomicLiquors/TPA_CHB/blob/main/hyobin/javascript/string/programmers_155652.js)

### for
- for… in의 각 항목은 숫자 인덱스가 아니라 문자열이다.  
  DP를 for in으로 풀었는데   
  idx+1이 1 + 1 = 2가 아니라 1 + “1” = 11이 되었다.  
  그래서 DP 테이블이 1부터 채워지지 않고 1, 11, 21... 처럼 채워지는 바람에 아래 꼴이 났다.
  ```
  [[7],[10,0],[18,1,0,null,null,null,null,null,null,null,null,1],[20,8,4,0,null,null,null,null,null,null,null,8,null,null,null,null,null,null,null,null,null,4],[24,13,6,6,0,null,null,null,null,null,null,13,null,null,null,null,null,null,null,null,null,6,null,null,null,null,null,null,null,null,null,6]]
  ```
### 정규식
- .match()에 정규식 넣을 때는 쌍따옴표를 쓰지 않는다.
```
// (x) : .match()가 null을 반환한다.
this.id = id.match("/[a-z0-9-_.]/g").join("");
// (o)
this.id = id.match(/[a-z0-9-_.]/g).join("");
```

- 문자열 끝을 나타내는 $ 기호 활용하기
  - [신규 아이디 추천](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/regex/2021_KAKAO_BLIND_RECRUIT_LV1.js)
 
### 누적합
- [2차원 배열의 특정 범위 값 채우기](https://github.com/TPA-ThreeProblemsAday/TPA_CHB/blob/main/hyobin/javascript/prefix/2D/Programmers_92344.js)
  - [해설](https://kimjingo.tistory.com/155)
