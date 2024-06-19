function solution(queue1, queue2) {
    
    let count = 0;
    
    const max = 3 * queue1.length;
    
    let sum1 = queue1.reduce((acc, elem) => acc + elem);
    let sum2 = queue2.reduce((acc, elem) => acc + elem);
    
    let curr;
    
    if( (sum1 + sum2) % 2 == 1 ) 
        return -1;
    
    while(sum1 != sum2){
        if(sum1 > sum2){
            curr = queue1.shift();
            queue2.push(curr);
            sum1 -= curr;
            sum2 += curr;
        }else{
            curr = queue2.shift();
            queue1.push(curr);
            sum2 -= curr;
            sum1 += curr;
        }
        
        if(++count >= max){
            return -1;
        }
    }
    
    return count;
}

// 시간 초과, 90점, 테스트 케이스 22, 23, 24 통과되지 않음
// 어떻게 정답에 해당하는 과정을 따라갈 것인가? 완전 탐색? 그러려니 소모해야 할 메모리가 너무 많다.
// 이분탐색 풀이법과 흡사한 탐욕법 기법을 떠올려 냈다. 매번 회차마다 합계 값을 비교해서, 합계가 큰 쪽에서 뽑아다가 작은 쪽에 더했다.
// 단 '불가능한 경우'를 어떻게 최적의 방법으로 찾아낼 건지 확실히 알지 못했다. 가능한 최대 원소 갯수를 고려해 막연히 큰 수를 넣었는데(300000) 이게 왜 최적인지 증명하지 못했다.
// 옛날 정답 코드도 돌려 봤는데 똑같은 케이스에서 걸린다. 이제는 투포인터만 정답으로 인정되는 모양이다.
