
## Java에서 Regex 사용하는 문법.

### 정규 표현식 패턴에 대해서는 Pattern.md로.
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Pattern.md)

### String 내장 메서드
일치 여부 검증
```java
str.matches("pattern");
```
- String.matches(): 문자열이 정규 표현식과 완전히 일치하는지 확인.
- String.replaceAll(): 정규 표현식과 일치하는 부분을 다른 문자열로 대체.
- String.split(): 정규 표현식을 기준으로 문자열을 분할.
- String.replaceFirst(): 첫 번째로 일치하는 부분만 대체.

일치하는 문자열 반환은 replaceAll()을 응용할수도 있지만 Pattern 사용을 권장
```java
public class StringRegexExample {
    public static void main(String[] args) {
        // 검사할 문자열
        String input = "hello world";
        // 정규 표현식 (모음 찾기)
        String regex = "([^aeiou]*)"; // 모음이 아닌 부분을 빈 문자열로 대체하여 모음 추출

        // 일치하는 부분을 추출
        String result = input.replaceAll(regex, "");
        System.out.println("Extracted: " + result);
    }
}

```

<br>

### Pattern 클래스 사용하기
```java
Pattern pattern = Pattern.compile("\\d");
Matcher matcher = pattern.matcher(searchTarget);
```
- Pattern.compile(regex)는 주어진 정규 표현식을 패턴으로 컴파일합니다.
- matcher.find()는 입력 문자열에서 정규 표현식과 일치하는 부분을 찾습니다.
- matcher.group()는 일치한 문자열을 반환합니다.

<br>

## 문제풀이 예시
- ['하나 이상'의 유무에 주의하기](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_9996.java)
- 문자열 반복 : 똑같은 문자, 또는 같은 그룹에 속하는 문자
    - [1](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_4659.java)
    - [2](https://school.programmers.co.kr/learn/courses/30/lessons/133499)
- [대소문자 무시](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/regex/Main_5698.java)
  
