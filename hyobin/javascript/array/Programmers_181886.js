// 5명씩 담기

function solution(names) {
    let answer = [];
    let idx = 0;
    let length = names.length;

    for(let name of names){
        answer.push(names[idx]);
        idx += 5;

        if(idx >= length)
            break;
    }
    return answer;
}
