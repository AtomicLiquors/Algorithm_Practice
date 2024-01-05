// 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기

function solution(myString, pat) {
    var answer = '';
    const arr = myString.split(pat);
    for(let i = 0; i < arr.length - 1; i++){
        answer += arr[i] + pat;
    }
    return answer;
}

//const solution = (str, pat) => str.substring(0, str.lastIndexOf(pat)) + pat
