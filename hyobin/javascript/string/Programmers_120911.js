// 문자열 -> 배열은 spread 연산자 사용이 가능하다.

function solution(my_string) {
    return my_string.toLowerCase().split("").sort().join("");
}

/* 모범답안 */
function solution(s) {
    return [...s.toLowerCase()].sort().join('')
}
