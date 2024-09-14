### 👨‍💻 About
이분탐색 풀이 및 팁 저장소

<br>

### .BinarySearch()
찾고자 하는 원소가 없을 경우, 근접한 위치도 찾아준다.   
해당하는 경우에 (-근접한 위치)-1 값을 반환한다.  
[[설명]](https://codingdog.tistory.com/entry/java-arrays-binarysearch-%ED%95%A8%EC%88%98%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B4%85%EC%8B%9C%EB%8B%A4)  

```java
int key = Arrays.binarySearch(trees, mid);
if(key < 0)
key = -key - 2;
```
#### 활용예시
[[Main_2805]](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Main_2805.java)

<br>

### 이분 탐색의 대상은 배열의 인덱스뿐만이 아니다
[링크](https://st-lab.tistory.com/269)

<br>

### 상한과 하한 개념
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Lower__UpperBound.md)

<br>

### TroubleShooting
[[Main_2805]](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Main_2805.java)  
[[탈출 조건 : left <= right vs left < right]](https://www.acmicpc.net/blog/view/109)  
[[상한, 하한 직접 구현시 정수 오버플로우]](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Lower__UpperBound.md#-troubleshooting)  
구현 실수 - ```arr[mid]```가 아니라 ```mid```를 비교한 경우  
