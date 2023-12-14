// 아스키 코드 기본

const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    let answer = "";
    let curr;
    for(let i = 0; i < str.length; i++){
        curr = str[i].charCodeAt();
        if(curr >= 97)
            answer += String.fromCharCode(curr - 32);
        else 
            answer += String.fromCharCode(curr + 32);
    }
    console.log(answer);
});
