/* 배열 조각하기 */

// Array.prototype.slice()
// "begin 부터 end 까지(end 미포함)에 대한 얕은 복사본을 새로운 배열 객체로 반환합니다."
// begin만 넣고 end 생략 가능
function solution(arr, query) {
    
    let answer = arr;
    
    for(let i = 0; i < query.length; i++){
        if(i % 2 > 0){
            answer = answer.slice(query[i]);
        } else {
            answer = answer.slice(0, query[i] + 1);
        }
    }
    
    return answer;
}

/* 매번 slice를 사용하지 않고, 인덱스만 조절해 답을 구하는 풀이법 */
/*
function solution(arr, query) {
    let start = 0;
    let end = 0;

    for(let i = 0; i < query.length; i++){
        if(i%2===0){
            end = start + query[i];
        } else {
            start += query[i];
        }
    }
    return arr.slice(start, end).length ?
        arr.slice(start, end) : [-1]
}
*/
