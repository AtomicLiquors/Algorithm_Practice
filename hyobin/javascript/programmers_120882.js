// 등수 매기기

function solution(score) {
    const targets = [];
    for(const s of score){
       targets.push(s[0] + s[1]);
    }
    
    const sorts = [...targets].sort(function(a, b){return a - b}).reverse();
    // splice()는 새로운 배열을 리턴하지 않으며 기존 배열에 직접 접근한다.
    // sort() 와 reverse() 사용.
    // javascript sort()는 숫자 값이 아닌 사전순으로 정렬한다.
    
    
    const map = new Map();
    
    
    for (let i = 0 ; i < sorts.length; i++){
        if(!map.get(sorts[i]))
            map.set(sorts[i], i + 1);
    }
    
    const answer = [];
    for(const t of targets){
       answer.push(map.get(t));
    }
    return answer;
}
