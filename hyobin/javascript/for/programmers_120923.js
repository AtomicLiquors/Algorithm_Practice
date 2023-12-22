// 연속된 수의 합

function solution(num, total) {
    const answer = [];
    for(let i = -1000; i <= 1000; i++){ // 음의 정수를 배제하고 i = 0으로 시작하여 오답 발생.
        if( (i * num) + (num * (num - 1)) / 2  === total){
            for(let j = 0; j < num; j++){
                answer.push(i + j);
            }
            break;
        }
    }
    return answer;
}

// 모범답안 1
/*
function solution(num, total) {
    var min = Math.ceil(total/num - Math.floor(num/2));
    var max = Math.floor(total/num + Math.floor(num/2));

    return new Array(num).fill(0).map((el,i)=>{return i+min;});
}*/
// total/num => 수열의 평균값, num/2 => 수열의 마지막에서 중앙까지의 등차 계산. ceil와 floor를 활용 수 있는 이유는 등차가 1이기때문이다.

// 모범답안 2
/*
function solution(num, total) {
    const a = (2 * total / num + 1 - num) / 2
    return Array(num).fill().map((_, i) => i + a)
}
*/
// "fill 인자 안에 a의 계산값 넣어서 변수 선언 줄일 수 있습니다"
