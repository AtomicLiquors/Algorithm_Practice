function solution(lottos, win_nums) {
    var answer = [];
    
    let maxRank = 7;
    let minRank = 7;
    
    const map = new Map();
    
    for(let num of win_nums){
        map.set(num, true);
    }
    
    for(let i in lottos){
        if(lottos[i] == 0) {
            maxRank--;
        }else if(map.get(lottos[i])){
            maxRank--;
            minRank--;
        }
    }
    
    answer.push(maxRank == 7 ? 6 : maxRank);
    answer.push(minRank == 7 ? 6 : minRank);
    
    return answer;
}


/* filter 활용 */
function solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];

    let minCount = lottos.filter(v => win_nums.includes(v)).length;
    let zeroCount = lottos.filter(v => !v).length;

    const maxCount = minCount + zeroCount;

    return [rank[maxCount], rank[minCount]];
}

// !0이 true 임을 이용했군요 
// 매번 includes를 실행하면 시간복잡도 측면에서 최악이네요. 만약 6개가 아니라 100개, 1000개를 선택하는 문제였으면...
// filter 두개는 for문 하나로 합칠 수 있을 것 같습니다.
