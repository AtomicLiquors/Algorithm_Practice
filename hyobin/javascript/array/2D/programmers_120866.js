function solution(board) {
    const n = board.length;
    let answer = n * n;
    
    const dR = [-1, -1, -1, 0, 0, 1, 1, 1];
    const dC = [-1, 0, 1, -1, 1, -1, 0, 1];
    
    for (let i = 0; i < n; i++){
        for(let j = 0; j < n; j++){
            if(board[i][j] == 1){
                answer--;
                let nr, nc;
                for(let x = 0; x < 8; x++){
                    nr = i + dR[x];
                    nc = j + dC[x];
                    if(nr < 0 || nc < 0 || nr >= n || nc >= n)
                        continue;
                    if(board[nr][nc] == 0){
                        board[nr][nc] = 2;
                        answer--;
                    }
                }
            }
        }
    }
    
    return answer;
}
