### Map
#### Map과 Set으로 시뮬레이션 최적화
[링크](https://github.com/AtomicLiquors/Algorithm_Practice/blob/main/simulation/Main_16946_GPT.java)

<br> 

#### 찾는 키가 존재한다면 찾는 키의 값을 반환하고, 없다면 기본 값을 반환하는 메서드
```
[Map - getOrDefault()](https://gymdev.tistory.com/39)
```
Before)
```java
 Integer count = map.get(key);
        
        if(count == null)
            map.put(key, 1);    
        else
            map.put(key, count + 1);
```
After)
```java
 map.put(key, map.getOrDefault(key, 0) + 1);
```

<br> 

#### Map의 Key들을 이용해 리스트 만들기
  ```
  List<Integer> list = new ArrayList<>(map.keySet())
  ```


<br> 

#### Map의 Key 순환
  ```java
    for (String key : map.keySet()) {
  ```
  ```java
    Iterator<String> keys = map.keySet().iterator();
    while (keys.hasNext()) {
        //...
    }
  ```
