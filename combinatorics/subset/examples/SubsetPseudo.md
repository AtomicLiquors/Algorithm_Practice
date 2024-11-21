### 반복문 형태
```
FOR i in 1 -> 0
	selected[1] <- i //원소 1
	FOR j in 1 -> 0	
		selected[2] <- i //원소 2
		FOR k in 1 -> 0
			selected[3] <- i //원소 3
			FOR m in 1 -> 3 //생성된 부분집합 출력
				if selected[i] == 1 then print i
```

<br>

### 재귀 형태
```
input[] 
isSelected[]
generateSubSet(cnt)
		if(cnt==N)
				부분집합 완성
		else
				isSelected[cnt] <- true
				generateSubSet(cnt+1) //다음 원소로 이동
				//뒤에 가능한 모든 선택이 다 끝났다.
				isSelected[cnt] <- false //나를 포함한 회차는 끝났어, 이제 나를 제외하고 새로운 회차 시작.
				generateSubSet(cnt+1)

end generateSubSet()
```
