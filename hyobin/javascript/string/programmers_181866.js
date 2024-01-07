// 문자열 잘라서 정렬하기
const solution = (myString) => {
    let answer = myString.split("x").sort();
    while(answer[0] === ""){
        answer = answer.slice(1);
    }
    return answer;
}

// 정규 표현식 활용
// const solution=s=>s.match(/[^x]+/g).sort()
