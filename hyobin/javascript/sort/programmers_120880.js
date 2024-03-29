function solution(numlist, n) {
    
    return numlist.sort((a, b) => {
        const A = Math.abs(n - a);
        const B = Math.abs(n - b);
        return  A === B ? (a < b ? 1 : -1) : (A > B ? 1 : -1)
    });
}

/* 모범답안 */
function solution(numlist, n) {
  return numlist.sort((a, b) => Math.abs(a - n) - Math.abs(b - n) || b - a);
}
// ||의 좌항이 0일 경우에는 우항의 연산을 수행한다.
