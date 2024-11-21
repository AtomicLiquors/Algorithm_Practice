PQ는 들어오고 나가는 순서 정렬을 보장하지 않는다.  
최댓값, 최솟값이 무엇인지에만 관심을 가질 뿐이다.


```java
Arrays.sort(arr, new Comparator<String[]>() {
    @Override
    public int compare(String[] s1, String[] s2) {
        return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
    }
});
```

### 2개의 조건
```java
Arrays.sort(arr, new Comparator<String>() {
    public int compare(String s1, String s2){

        if(s1.length() == s2.length()){
        return s1.compareTo(s2);
        }

        else{
            return s1.length()-s2.length();
        }
    }
});
```
