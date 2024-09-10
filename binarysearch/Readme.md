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

<br>

#### 활용예시
[[Main_2805]](#)


### TroubleShooting
[[Main_2805]](#)  
[[이분 탐색은 off-by-one error가 발생하기 쉬워서 늘 헷갈립니다.]](https://www.acmicpc.net/blog/view/109)