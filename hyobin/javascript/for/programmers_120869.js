// 외계어 사전
function solution(spell, dic) {
    let answer = 2;
    for(const word of dic){
        let doesExist = false;
        for(const s of spell){
            if(word.split(s).length <= 1){
                doesExist = false;
                break;
            }else{
                doesExist = true;
            }
        }
        if(doesExist){
            answer = 1;
            break;
        }
    }
    return answer;
}

// .some, .every, .filter 메서드로 더 간단하게 풀기.
