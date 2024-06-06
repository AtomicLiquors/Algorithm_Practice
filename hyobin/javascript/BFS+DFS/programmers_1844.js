function solution(maps) {
    let answer = -1;
    
    const N = maps.length;
    const M = maps[0].length;
    
    const que = [];
    const dR = [0, 0, -1, 1];
    const dC = [-1, 1, 0, 0];
    const visited = 
          Array.from(
              { length: N }, 
              () => Array.from({ length: M }, () => false)
          );
    visited[0][0] = true;
    que.push([0,0,1]);
    
    
    while(que.length > 0){
        const curr = que.shift();
        const r = curr[0];
        const c = curr[1];
        const cnt = curr[2];
        
        if(r == N-1 && c == M-1){
            answer = cnt;
            break;
        }
            
        
        let nr, nc;
        for(let i = 0; i < 4; i++){
            nr = r + dR[i];
            nc = c + dC[i];
            
            if(nr < 0 || nc < 0 || nr >= N || nc >= M)
                continue;
            
            if(visited[nr][nc] || maps[nr][nc] == 0)
                continue;
            
            visited[nr][nc] = true;
            que.push([nr, nc, cnt+1]);
        }
    }
    
    return answer;
}

// 다른 풀이방법 확인.
// https://school.programmers.co.kr/learn/courses/30/lessons/1844/solution_groups?language=javascript
