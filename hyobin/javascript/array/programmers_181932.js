// https://school.programmers.co.kr/learn/courses/30/lessons/181932

function solution(code) {
    
    let mode = 0;
    const answer = code.toString().split('').reduce((ret, curr, idx) => {
        if(curr == 1){
            mode = (mode + 1) % 2;
        }else{
            if(idx % 2 === mode)
                return ret + curr;
        }
        return ret;
    }, "");
    
   
   return answer === "" ? "EMPTY" : answer;
}
// reduce 내부에서 조건문을 써서 풀었는데, return이 없는 분기에서 누산 결과는 undefined가 된다.


/*다른 답안*/
function solution(code) {
    let odd = false
    return Array.from(code).reduce((acc, v, i) => {
        if (v === '1') {
            odd = !odd
            return acc
        }
        return (i % 2 === (odd ? 1 : 0)) ? acc + v : acc
    }, '') || 'EMPTY'
}

// 숫자 -> 배열 변환을 위해 Array.from 활용
// ""는 falsy한 값, 불리언 연산 활용 가능
