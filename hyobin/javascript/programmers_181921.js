function solution(left, right) {
    let base = 5;
    let offset = 1;
    
    let answer = [0];
    let temp = [];
    let value = 0;
    let flag = true;
    
    while(flag){
        for (let curr of answer){
            value = base + curr;
            if(value > right){
                flag = false;
                break;
            } 
            
            temp.push(base + curr);
            if(value < left) offset++;
        }
        answer = [...answer, ...temp];
        temp = [];
        base *= 10;
    }
    
    
    answer = answer.slice(offset);
    return answer[1] ? answer : [-1]
}

/* 모범답안 1 */
function solution(l, r) {
    const result = Array.from({length:r-l+1}, (_,i)=>i+l).filter(n=>!/[^05]/.test(n));
    return result.length ? result : [-1];
}

/* 모범답안 2 */
// 숫자 5로 현혹시켰지만 사실 이건 이진수 문제임.
function* gen50() {
    let i = 1;

    while(true) {
        yield Number(Number(i).toString(2)) * 5;
        i++;
    }
}
function solution(l, r) {
    const n = gen50();
    let a = 0;
    const arr = [];

    while(a < l) { a = n.next().value; }
    while(a <= r) { arr.push(a); a = n.next().value; }

    return arr.length ? arr : [-1];
}
