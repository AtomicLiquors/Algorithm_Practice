// 원하는 문자열 찾기
/* 120908과 동일한 문제, 모범답안 */
function solution(myString, pat) {
    
    const ms = myString.toLowerCase();
    const pt = pat.toLowerCase();
    
    return ms.split(pt).length > 1 ? 1 :0;
    // ms.split(pt).length == 2로 할 경우 문자열이 중복해서 포함되는 경우(따라서 length가 3, 4, 5...인 경우)를 제해버리므로 오답이다.
}
