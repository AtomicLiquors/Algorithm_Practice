### CharArray를 String으로
String 생성자를 이용한다.
```java
new String(charArray);
```

<br>

### Split 사용의 함정
split()의 매개변수는 일반 문자열이 아닌 [정규 표현식](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Pattern.md)이다.  
.과 같은 문자는 정규 표현식에서 특수 문자이기 때문에,  
. 등을 사용해서 문자열을 분리하려면 반드시 ```\\.```과 같이 백슬래시 두개를 붙여서 사용해야 한다.  

관련 문제 : [Softeer GPT식 숫자 비교](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/comparator/HSAT_11001.java)
