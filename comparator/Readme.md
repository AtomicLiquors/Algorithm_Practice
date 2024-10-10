### 👨‍💻 About
PQ, .sort() 등 Comparable/Comparator 연관 내용을 취합하는 저장소
  
<br>
  
### String 사전순 정렬
```java
str1.compareTo(str2)
```

### 임의의 Comparator로 배열 정렬하기
```java
Arrays.sort(people, new Comparator<Person>() {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.age, p2.age); // 또는 p1.age - p2.age
    }
});
```
