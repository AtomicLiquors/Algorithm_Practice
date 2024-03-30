let str;
let len;

function solution(s) {
    str = s;
    len = str.length;
    
    return recur(0);
}

function recur(start){
    let sum = 1;
    if(start >= len) return 0;
    
    let count = 1;
    let char = str[start];
    let idx = start;
    while(++idx < len){
        count += (str[idx] === char ? 1 : -1);
        if(count === 0){
            sum += recur(idx + 1);
            break;
        }
    }
    return sum;
}
