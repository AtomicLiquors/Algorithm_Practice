[원본 링크 : Stranger's Lab](https://st-lab.tistory.com/267) 

Java의 ```binarySearch()``` 메소드는 lower_bound 형식이고, upper_bound 형식은 제공하지 않는다.

<br>

## 📍 개념정리
- lower bound 는 '하한'을 의미하며, upper bound는 '상한'을 의미한다. 흔히 경계를 의미하는 뜻에서 하계, 상계라고도 한다.

<br>

- lower bound, 하한은 "찾고자 하는 값 이상의 값"이 처음으로 나타나는 위치를 의미한다.
- upper bound, 상한은 "찾고자 하는 값을 **초과하는 값**"이 처음으로 나타나는 위치를 의미한다.  
  찾고자 하는 값이 더 이상 넘어갈 수 없는 위치이기 때문에 '상한'이다.

  다음 배열에서
  ```java
  [1, 2, 2, 4, 4, 4, 6, 7, 7, 9]
  ```
  '4'를 탐색했을 때,    
  lower_bound 탐색은 4가 처음으로 등장하는 위치인 인덱스 3을 반환한다.    
  upper_bound 탐색은 4를 넘는 값(6)이 처음으로 등장하는 위치인 인덱스 6을 반환한다.  

  '5'를 탐색했을 때,  
  lower_bound 탐색은 5 이상의 값(6)이 처음으로 등장하는 위치인 인덱스 6을 반환한다.  
  upper_bound 탐색은 5를 넘는 값(6)이 처음으로 등장하는 위치인 인덱스 6을 반환한다.  

<br>

## 📍 활용 방법
상한과 하한의 차이를 구하면 **"중복 원소의 길이"**를 구할 수 있다.
```
상한 - 하한 = 중복 원소에 대한 길이
```
위의 예시에서  
4에 대해서 중복 원소에 대한 길이는 6 - 3 = 3이다.
5에 대해서 중복 원소에 대한 길이는 6 - 6 = 0인데, 실제로 5는 배열에 존재하지 않으므로 옳은 결과값이다.

<br>

## 📍 코드 
### lowerBound
```
int lowerBound(int[] arr, int key){
	int lo = 0; 
	int hi = arr.length; 
  // lo, hi가 일치하면 반복문 종료
  while(lo < hi){
    int mid = (lo + hi) / 2;

    // 중간 위치의 값보다 작거나 같을 경우 상한선을 낮춘다.
    if (key <= arr[mid]){
      hi = mid;
    }else{
      lo = mid + 1;
    }
  }
  return lo;
}
```

<br>

### upperBound
```
int upperBound(int[] arr, int key){
	int lo = 0; 
	int hi = arr.length;

  // 마찬가지로 lo, hi가 일치하면 반복문 종료
  while(lo < hi){
    int mid = (lo + hi) / 2;

    // lowerBound와는 다르게 중간 위치의 값보다 반드시 작을 경우에만 상한선을 낮춘다.
    if (key < arr[mid]){
      hi = mid;
    }else{
      lo = mid + 1;
    }
  }
  return lo;
}
```
<br>

## 📍 TroubleShooting
정수 오버플로우.  
```lo = 1```이고 ```hi = Integer.MAX_VALUE```라면 ```mid```는 엉뚱한 음수 값을 갖게 된다.  

이럴 경우 중간 값 계산을 다른 접근법으로 수행해 준다.  
lo와 hi의 중간 값은, lo에다가 (hi - lo)/2를 더한 값과 같으므로 다음과 같이 표현할 수 있다.
```java
mid = lo + ((hi - lo) / 2)
```

그 밖에 HashMap이나 Counting 정렬을 사용하는 방법이 있다고 한다.


