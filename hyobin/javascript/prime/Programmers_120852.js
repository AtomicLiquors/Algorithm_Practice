function solution(n) {
    // 소인수를 "종류별로 하나씩" 구하기.
    const answer = [];
    
    let limit = Math.sqrt(n);
    
    if(n % 2 == 0){
        answer.push(2);
        while(n % 2 == 0)
            n /= 2;
    }
    // 짝수면 2를 먼저 나눠준다.
    
    for(let i = 3; i <= limit; i += 2){
        // 2씩 건너뛰면서 제곱근 이하의 수에 대해 동일한 연산을 수행해 준다.
        if(n % i == 0){
            answer.push(i);
            while(n % i == 0)
                n /= i;
        }
    }
    
    if(n > 2) answer.push(n);
    // 다 나누고 남은 값이 있다면 그것도 소인수다.
    // https://st-lab.tistory.com/152 참조.
    
    return answer;
}
