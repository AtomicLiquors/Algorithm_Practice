// 2차원으로 만들기
function solution(num_list, n) {
    let answer = [];
    let i = 0;
    let j = 0;
    
    for(let k = 0; k < Math.floor(num_list.length / n); k++){
        answer.push([]);
    }
    
    num_list.map((num) => { 
        answer[i].push(num);
        i = Math.floor(++j / n);
    })
    return answer;
}


/*
splice 이용
function solution(num_list, n) {
    var answer = [];

    while(num_list.length) {
        answer.push(num_list.splice(0,n));
    }

    return answer;
}

*/
