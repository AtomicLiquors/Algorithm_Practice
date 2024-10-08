## 소수 여부 확인
### 제곱근 활용

```java
public static boolean isPrime(int num){ //소수인지 검증하는 불리언 메서드
        if(num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
```

<br>

### 에라토스테네스의 체
boolean 배열을 만들어서 2부터 시작해서 소수의 배수들을 싹 지워버린다.  

테케를 반복해서 돌릴 때 효율적일 수 있다.  
연산을 적게 하려고 하면.  
단 공간 비용이 크다.  
(백준 신기한 소수 : 4MB 제한 문제인데 배열을 만드는 데만 1억 바이트(100MB)가 필요하다.)

비트마스킹을 사용하면 그나마 공간 효율적이니 알아볼 것.

<br>
