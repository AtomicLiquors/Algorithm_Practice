// 반례 1) 입력값에서 빈 문자열을 제거해 주지 않았다.
// 마지막 반복문 실행범위를 i < max를 i <= max로 수정해 주었다.

const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');

const N = +input[0];
const arr = input[1].split(' ').filter((item) => item !== '').map(Number);

const max = Math.max(...arr);

function isPrime(num, max){
    if(num <= 1) return false;
    for(let i = 2; i < Math.sqrt(max); i++){
       if(i % num === 0) continue;
    }
    return true;
}

let answer = 0;

for(let i = 0; i <= max; i++){
    if(isPrime(i)){
        const houses = arr.reduce((acc, item) => acc + ( (item % i === 0) ? 1 : 0), 0);
        answer = Math.max(answer, houses);
    }
}

console.log(answer);
