// 다항식 더하기
function solution(polynomial) {
    const terms = polynomial.split(' + ');
    
    let xTerm = 0;
    let constant = 0;
    
    
    let answer = "";
    
    for(let term of terms){
        const curr = term.split('x');
        if(curr.length > 1){
            xTerm += (curr[0] === "" ? 1 : Number(curr[0]));
        } else {
            constant += Number(curr[0]);
        }
    }
    if(xTerm > 0){
        answer += (xTerm === 1 ? "" : xTerm) + 'x';
        if(constant > 0)
            answer += ' + ';
    }
    if (constant > 0){
        answer += constant;
    }
    
    return answer;
}
