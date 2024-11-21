### 반복문 구현
```
for i from 1 to 4
		for j from i+1 to 4 //i+1부터 뽑고
				for k from j+1 to 4 //j+1부터 뽑는다...!
						print i, j, k
				end for
		end for
end for
```

<br>

### 재귀로 구현

```
input[] : n개 원소를 가진 배열
numbers[] : r개 크기의 배열, 조합이 저장될 배열

comb(cnt, start) 
//cnt : 현재까지 뽑은 조합 원소 개수, 
//start: 조합 시도할 원소의 시작 인덱스
		if cnt == r 
				'조합 생성 완료'
		else
				for i from start to n-1 
							numbers[cnt] <- input[i];
							comb(cnt+1, i+1);
							//comb(cnt+1, start+1); 쓰면 안 되는 이유?
				end for
end comb()
```

<br>
