function solution(s) {
    
    let answer = "";
    
    const map = {
        "zero": 0,
        "one": 1,
        "two": 2,
        "three": 3,
        "four": 4,
        "five": 5,
        "six": 6,
        "seven": 7,
        "eight": 8,
        "nine": 9
    }
    
    let str = "";
    
    for(const char of s){
        const num = Number(char);
        if(Number.isInteger(num))
            answer = addToEnd(answer, Number(char));
        else{
            str += char;
            if(Number.isInteger(map[str])){
                answer = addToEnd(answer, map[str]);
                str = "";
            }
        }
    }
    
    return answer;
}

function addToEnd(origin, additive){
    return origin * 10 + additive;
}
