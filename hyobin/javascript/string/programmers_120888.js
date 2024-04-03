function solution(my_string) {
    const cache = [];
    
    let i = -1;
    let answer = "";
    while(++i < my_string.length){
        if(!cache[my_string.charCodeAt(i)]) {
            answer += my_string[i];
            cache[my_string.charCodeAt(i)] = true;
        }
    }
    
    return answer;
}

/* 모범답안 */
function solution(my_string) {
    return [...new Set(my_string)].join('');
}
// string을 Set으로 바꿔서 중복을 제거할 수 있다.
