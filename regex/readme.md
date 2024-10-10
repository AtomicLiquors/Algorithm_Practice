
## Regex 패턴에 대해서는 Pattern.md로.
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Pattern.md)

## Java에서 Regex 사용하기
### String 내장 메서드
일치 여부 검증
```java
String.matches("String");
```

### Pattern 클래스 사용하기
```
Pattern pattern = Pattern.compile("\\d");
Matcher matcher = pattern.matcher(searchTarget);
```

<br>

## 문제풀이 예시
- ['하나 이상'의 유무에 주의하기](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_9996.java)
- [문자열 반복 : 똑같은 문자, 또는 같은 그룹에 속하는 문자](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_4659.java)
- [대소문자 무시](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_5698.java)
  
