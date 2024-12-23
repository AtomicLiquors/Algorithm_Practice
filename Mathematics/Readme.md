### 👨‍💻 About
수학과 관련된 코드, 문제풀이 저장소

<br>

### 목차
- [이진수](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics/Binary)
- [최대공약수](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics/GCD)
- [소수](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics/PrimeNumber)
- [수식계산](https://github.com/AtomicLiquors/Algorithm_Practice/tree/main/Mathematics/ExpressionParsing)

<br>

### 숫자 자릿수 구하기
```java
int length = (int)Math.log10(n) + 1
```

<br>

### 내림, 올림 기호
⌊ ⌋가 내림, ⌈ ⌉가 올림


### 정수를 부호에 따라 -1, 0, 1로 변환하기
```java
Integer.signum()
```

```java
public static int getSign(int num) {
        if (num > 0) {
            return 1;
        } else if (num < 0) {
            return -1;
        } else {
            return 0;
        }
    }
```
