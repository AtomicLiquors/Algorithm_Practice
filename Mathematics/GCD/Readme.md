


## 유클리드 호제
### 서로소 여부 확인하기
```java
static boolean isCoprime(int a, int b){
	while(b!=1){
		if(a%b==0) return false;
	
		int temp = a;
		a = b;
		b = temp % b;
	}
	return true;
}
```

<br>


### 두 수의 최대공약수 구하기.
큰 수에서 작은 수 빼기를 반복해서(나머지 연산),

- 두 수가 같아지거나
- 나머지 연산을 해서 0이 나올 때

최대공약수가 나온다.

```java
public int gdc(int a, int b){
	if( b == 0 )
		return a;
	return gdc(b, a % b);
}
```

#### 1) R을 어떻게 최대공약수 G로 표현할 것인가?

```java
 A = Bq + R
```


A. 서로소인 두 수 a, b를 이용하여
A = a * G, B = b* G로 표현할 수 있다.


```java
  R = G(a-bq)
```

<br>

#### 2) B = G * b, R = G (a-bq)에서 b, a-bq가 서로소임을 증명하려면

A. **귀류법**을 이용한다.
(원명제를 **부정**하면 모순이 됨을 보임으로써, 원명제가 참임을 증명하는 방법)

b와 a-bq가 서로소가 아니라면, 
공약수 m이 존재한다.( k와 k ′는 서로소)


```java
  b = mk
  a - bq = mk'

  a = bq + mk'
  a = mkq + mk'
  a = m(kq + k')
  a = m(kq + k')
  b = mk
```

그런데 이 때 a와 b 또한 공약수 m을 가지게 되는데, 그러면 a와 b가 서로소라는 전제에 어긋난다.  

b와 a-bq는 서로소가 맞고, 이를 부정하면 모순이 발생한다는 것을 보였다.
