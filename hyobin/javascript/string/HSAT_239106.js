// 런타임 에러 코드
const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');

const N = +input[0];

let answer = "";
for(const line of input.slice(1)){
    const words = line.split(' ');
    const S = words[0];
    const T = words[1];

    let idx;
    for(let j = 0; j < S.length; j++){
        const char = S.charAt(j);
        if(char === 'x' || char === 'X'){
            idx = j;
            break;
        }
    }
    answer += T.charAt(idx);
}

console.log(answer.toUpperCase());

// 정답 코드
const fs = require('fs');
const input = fs.readFileSync(0).toString().split('\n');

const N = +input[0];

let answer = "";
for(const line of input.slice(1)){
    const words = line.split(' ');
    const S = words[0];
    const T = words[1];

    for(let j = 0; j < S.length; j++){
        const char = S.charAt(j);
        if(char === 'x' || char === 'X'){
            answer += T.charAt(j);
          // 수정 : idx 변수 선언 없이 j를 바로 받아서 정답에 합산.
            break;
        }
    }
}

console.log(answer.toUpperCase());
