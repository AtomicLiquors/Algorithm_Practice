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
- [[Main_2805]](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Main_2805.java)  
- [[탈출 조건 : left <= right vs left < right]](https://www.acmicpc.net/blog/view/109)  
- [[상한, 하한 직접 구현시 정수 오버플로우]](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/binarysearch/Lower__UpperBound.md#-troubleshooting)  
- 구현 실수 - ```arr[mid]```가 아니라 ```mid```를 비교한 경우  
- [[무한 루프가 일어나는 이유(유튜브)]](https://www.youtube.com/watch?v=b9SKfz58Jdo)

### 틀렸습니다  
백준 1654
```javascript
// X
while(top > bottom){ // 탈출 조건
        mid = Math.floor((top + bottom) / 2);
		const result = lans.reduce((acc, lan) => 
			acc + Math.floor(lan / mid)
		,0);
		
		if(result < N){
			top = mid; // top 갱신
		}else{
			answer = Math.max(mid, answer);
			bottom = mid+1; // bottom 갱신
		}
	}
```
```javascript
// O
while(top >= bottom){ // 등호 붙이고
        mid = Math.floor((top + bottom) / 2);
		const result = lans.reduce((acc, lan) => 
			acc + Math.floor(lan / mid)
		,0);
		
		if(result < N){
			top = mid-1; // top 하나 깎고
		}else{
			answer = Math.max(mid, answer);
			bottom = mid+1; // bottom 하나 붙이기
		}
			
	}
```
while문이 무한루프를 돌고 있다면, loop을 한번 돌 때, 범위가 하나도 줄어들지 않는 경우가 있다는 의미다.  
mid 계산, left, right값의 update 시 줄어들지 않는 경우가 있는지를 한번 확인해보자. 

<br>


## left = mid 는 사용하면 안 된다.
"바닥에서는 올라갈 일만 남았다."  
(Bottom = mid + 1, top = mid)

  
https://blossoming-man.tistory.com/entry/%EC%9D%B4%EC%A7%84-%ED%83%90%EC%83%89-Binary-Search-%EA%B2%BD%EA%B3%84-%EC%84%A4%EC%A0%95%EC%9D%84-%EC%96%B4%EB%96%BB%EA%B2%8C-%ED%95%B4%EC%95%BC-%ED%95%98%EB%8A%94%EA%B0%80
조건에 따라 될 수도 있겠지만 위 조건에서 left = mid를 사용하면 left, right 사이에 두 원소만 남았을 때 left가 움직이지 못 하므로 무한루프에 빠진다.  

mid 계산 시 정수로 내림하기 때문에 주의해야 할 점이다.

 

### left = mid는 안 되는데 right = mid는 왜 되는가?

mid 계산 특성 (정수 내림) 때문이다.  
두 원소만 남은 경우 mid는 left랑 같고 조건식을 만족하면 left가 right로 이동하고 조건식을 만족하지 않으면 right가 mid(이 경우에는 left랑 같음)로 이동하므로 left == right여서 반복문을 빠져나온다.  

 

 

### while 조건에 equal 포함 형태
```
left, right = 0, len(arr) - 1
while left <= right:
    mid = left + (right - left) // 2
    if arr[mid] < target:
        left = mid + 1
    else:
        right = mid - 1
        
return arr[left]
 ```

right = mid를 사용할 경우 left == right, arr[mid] == target 일 때 반복문을 못 빠져나오는 경우가 생긴다. 그래서 while 조건에서 등호가 포함되어 있을 경우 right = mid - 1을 사용한다.  

 

right = mid -1 을 사용하면 [left, right] 사이에 답이 없는 경우가 생기는데 괜찮나?  
간단하게 arr = [1, 3, 3, 5], target = 3 을 살펴보자.  
첫 번째 루프에서 mid = index 1이 되고 arr[mid] == target이기 때문에 right = index 0이 된다.  
left = right = index 0인 상태, 즉 arr[left : right+1] = [1]  

target 값인 3이 포함되어 있지 않다.  
하지만 걱정할 필요가 없다. right는 최대로 왼쪽으로 가봤자 가장 왼쪽에 있는 (target 이상의 값) 인덱스 - 1 이다.  
이 명제가 중요하다. 그리고 while의 등호 때문에 left == right여도 한번 더 left 또는 right의 움직임이 있다는 점 또한 중요하다.  
[1] 상태에서 target보다 작기 때문에 결국 left가 1 증가해서 값이 3인 원소를 가리키며 반복문이 끝난다.


target이 존재하는지 판단해야 한다면  
right를 배열의 가장 마지막 원소의 인덱스 + 1로 설정해주면 좋다
