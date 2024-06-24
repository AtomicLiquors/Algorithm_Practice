/* 정석은 투 포인터로 푸는 것이고, 누적합 3중 포문으로 접근했다가 시간 초과가 났다. */


/* 시간 초과 코드 */
/*
* 채점 결과
* 정확성: 33.3
* 효율성: 4.4
* 합계: 37.8 / 100.0
*/

function solution(gems) {
    
    const acc = [];
    acc.push(new Array(gems.length + 1).fill(0));
    const map = new Map();
    
    let r = -1;
    for(const c in gems){
        if(map.get(gems[c]) === undefined){
            map.set(gems[c], ++r);
            acc[r] = new Array(gems.length + 1).fill(0);
        }
        
        for(const row of acc){ row[+c + 1] = row[c]; }
        acc[map.get(gems[c])][+c + 1]++;
    }
    
    const answer = [];
    
    let gap = r+1;
    let found = false;
    
    while(gap < gems.length + 1){
        for(let i = gap; i < gems.length + 1; i++){
            let result = 1;
            for(const row of acc){
                const currentGems = row[i] - row[i - gap];
                result *= currentGems;
                if(result === 0) 
                    break;
            }
            
            if(result > 0){
                answer.push(i - gap + 1);
                answer.push(i);
                found = true;
                break;
            }
        }
        if(found) break;
        gap++;
    }
    
    return answer;
}
