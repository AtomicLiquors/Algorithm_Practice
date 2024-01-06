// 문자열 바꿔서 찾기

function solution(myString, pat) {
    let invertedPat = "";
    for(const char of pat){
        if(char === "B") invertedPat += 'A';
        else if(char === "A") invertedPat += 'B';
    }
    return myString.split(invertedPat).length > 1 ? 1 : 0;
}

// split -> length 쓰지 말고 includes로 대체 가능

/* 모범답안 */
// const solution = (myString, pat) => [...myString].map(v => v === 'A' ? 'B' : 'A').join('').includes(pat) ? 1 : 0
// 여기서 문자열 길이가 짧은 pat을 뒤집는 게 더 빠르다.

/* 수정답안 */
//const solution = (myString, pat) => myString.includes([...pat].map(c => c === 'A' ? 'B' : 'A').join('')) ? 1 : 0;
