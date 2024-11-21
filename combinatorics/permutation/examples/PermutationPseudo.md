### {1, 2, 3}을 포함하는 모든 순열 생성
[순열구현 — 반복문]
```
for i from 1 to 3 // 첫째 뽑기
	for j from 1 to 3	 //둘째자리 뽑기
		if j != i then   //중복체크
			for k from 1 to 3 //셋째자리 뽑기
				if k != i and k != j then //중복체크
					print i, j, k

//r이 늘어나면 반복문이 계속해서 중첩된다는 단점.

//Q. k 수가 적으면 반복문이 더 나을까?
// 3까지는 몰라도
```

<br>

[순열구현 — 재귀]
```
numbers[] //순열 저장
isSelected[] //인덱스에 해당하는 숫자가 사용 중인지 저장

perm(cnt) // cnt : 현재까지 뽑은 순열 원소의 개수
		if cnt ==3
				//1개의 순열 완성 시 수행할 로직
		else
			for i from 1 to 3
				if isSelected[i] == true then continue //중복체크
				numbers[cnt] <- i // 수 선택
				isSelected[i] <- true // 선택 여부 표기
				perm(cnt+1) //재귀호출 : 다음 자리 수 뽑기
				isSelected[i] <- false //사용 마친 수 되돌려놓기
		end for
```
