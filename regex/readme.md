자바에서는 escape 때문에 역슬래시 \를 두 번 적어야 합니다.
Python은 raw string을 지원해 대표 문자1를 표현할 때 역슬래시 \ 를 한 번만 쓸 수 있습니다. 
```
Pattern pattern = Pattern.compile("\\d");
Matcher matcher = pattern.matcher(searchTarget);
```

- ['하나 이상'의 유무에 주의하기](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_9996.java)
- [문자열 반복 : 똑같은 문자, 또는 같은 그룹에 속하는 문자](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_4659.java)
- [대소문자 무시](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_5698.java)
  

### 전화번호 찾기
다음 두 정규 표현식의 차이는?
```
- 내 답안 : "[0-9]+-[0-9]+-[0-9]+"
- 모범답안 : "0\d{1,2}[ -]?\d{3,4}[ -]?\d{3,4}"
```

  

### 자연수 찾기
0으로 시작하지 않는 자연수를 찾고 싶다면?
```
[1-9]\d*
```
- *는 "0개 이상"이라는 의미로, 위 정규 표현식은 [1-9]로 시작하며 0개 이상의 정수가 뒤에 달린 단어를 찾아주는 정규 표현식이다.


  
### 숫자 사이에 대쉬 또는 공백이 있거나 없음을 나타내기
```
\d+[- ]?\d+[- ]?\d+
```
- ?는 옵셔널이라는 의미다.

  
### 일정 갯수의 숫자
```
- \d{2} : 2개
- \d{2,3} : 2개 또는 3개
```




### 한글 찾기
```
[가-힣]
```
- 한글의 첫 번째 글자는 가이고 마지막 글자는 힣이다.


### \w의 탐색범위
숫자, 영문, 언더스코어
(확인바람)

