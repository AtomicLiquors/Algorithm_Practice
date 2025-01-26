### SubString: 전체 문자열에서 연속된 부분 문자열
일치하는 문자가 나오면  
이차원 DP 배열에서 좌측 상단으로 인접한 DP값을 더해주면 된다.
```java
if i == 0 or j == 0:  # 마진 설정 (빈영역 설정)
	LCS[i][j] = 0
else if string_A[i - 1] == string_B[j - 1]:
	LCS[i][j] = LCS[i - 1][j - 1] + 1
else:
	LCS[i][j] = 0
```

<br>

### Subsequence: 반드시 연속할 필요는 없는 부분 문자열
서로 떨어져 있는 문자열도 최장수열에 포함해야 하기 때문에 DP값을 유지하는 동작이 필요하다.  
- 일치하는 문자가 없으면
  좌측과 상단을 비교해서 최댓값을 대입한다.  
  이 동작의 의미를 예시를 들어 설명하자면, 
  'A와 GBC의 LCS, AB와 GB의 LCS를 비교하여 AB와 GBC의 LCS를 구한다'는 것이다.
- 일치하는 문자가 나오면  
  마찬가지로 이차원 DP 배열에서 좌측 상단으로 인접한 DP값을 더해준다.

<br>

### 참고자료
[블로그](https://velog.io/@jeongbeom4693/JAVA-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98)  

<br>

### To-Do
ABCDEFG와 ABAEFG의 최장 부분수열(SubString, Subsequence 각각) 길이를 구해 보시오.
