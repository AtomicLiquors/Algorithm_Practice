// 유한소수 판별하기

function solution(a, b) {
    let div = a;
    let target = b;
    
    for(let i = 2; i <= a; i++){
        while( div % i === 0 && target % i=== 0){
            div /= i;
            target /= i;
        }
    }
    
    let flag = true;
    while(target % 2 === 0){
        target /= 2;
    }
    
    while(target % 5 === 0){
        target /= 5;
    }
    
    return target === 1 ? 1 : 2;
}


/* 모범답안
function solution(a, b) {
    let n = 1;
    for (let i = 1; i <= Math.min(a,b); i++) {
        if (a%i===0 && b%i===0) n = i;
    }

    b/=n;
    while (b%2===0) b/=2;
    while (b%5===0) b/=5;

    return b === 1 ? 1 : 2;   
}*/
