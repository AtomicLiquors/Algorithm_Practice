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
