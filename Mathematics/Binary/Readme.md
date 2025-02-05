십진수 -> 이진수 문자열 변환
```java
Integer.toBinaryString(n);
```

<br>

이진수 형태 문자열을 정수 값으로 변환
```java
Integer.parseInt(String, 2);
```

<br>

이진수 자릿수 구하기
```java
Integer.toBinaryString(n).length;
```
<br>

이진수 비트 수 구하기
```java
int diffBits = Integer.bitCount(bit1 ^ bit2);
```

<br>

XOR(num)의 의미는? 
```java
Integer.bitCount(num) % 2;
```
등장 비트끼리 전부 XOR한 값을 구하는 것.  
결과적으로 비트의 개수에 2를 나눈 나머지가 된다.
