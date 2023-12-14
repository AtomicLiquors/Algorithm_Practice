// 주사위 게임

function solution(a, b, c, d) {
    let answer = 0;
    let valCache; 
    (valCache = []).length = 7;
    valCache.fill(0);
    
    valCache[a]++;
    valCache[b]++;
    valCache[c]++;
    valCache[d]++;
    
    let countCache;
    (countCache = []).length = 5;
    
    countCache[1] = [];
    countCache[2] = [];
    
    for(let i = 1; i <= 6; i++){
        if ( valCache[i]  == 0 ) continue;
        else if ( valCache[i] <= 2) 
            countCache[valCache[i]].push(i);
        else 
            countCache[valCache[i]] = i;
    }
    
    if(countCache[4] > 0){
        answer = 1111 * countCache[4];
    }else if(countCache[3] > 0){
        answer = Math.pow(10 * (countCache[3]) + countCache[1][0], 2);
    }else{
        len2 = countCache[2].length;
        if(len2 == 2){
            answer = (countCache[2][0] + countCache[2][1]) * Math.abs(countCache[2][0] - countCache[2][1]);
        } else if(len2 == 1) {
            answer = countCache[1][0] * countCache[1][1];
        }else{
            answer = 7;
            for(let i = 0; i < countCache.length; i++){
                if ( answer > countCache[1][i] )
                    answer = countCache[1][i];
            }
        
        }
    } 
    
    return answer;
}
