//누적합으로 특정 범위 값 채우기

function solution(board, skill) {
    const rows = board.length;
    const cols = board[0].length;
    const acc = Array.from({length:rows}, () => new Array(cols).fill(0));
   
    for(const cmd of skill){
        const [type, r1, c1, r2, c2, degree] = cmd;
        const sign = (type == 1 ? -1 : 1);
        acc[r1][c1] += degree * sign;
        
        const inBound3 = (r2+1 < rows);
        const inBound4 = (c2+1 < cols);
        
        if(inBound3 && inBound4)
            acc[r2+1][c2+1] += (degree * sign);
        if(inBound3)
            acc[r2+1][c1] += (degree * sign * -1);
        if(inBound4)
            acc[r1][c2+1] += (degree * sign * -1);
    }
    
    for(let r = 0; r < rows; r++){
        for(let c = 1; c < cols; c++){
            acc[r][c] += acc[r][c-1];
        }   
    }
    
    for(let r = 1; r < rows; r++){
        for(let c = 0; c < cols; c++){
            acc[r][c] += acc[r-1][c];
        }   
    }
    
    let answer = 0;
    for(let r = 0; r < rows; r++){
        for(let c = 0; c < cols; c++){
            board[r][c] += acc[r][c];
            if(board[r][c] > 0)
                answer++;
        }    
    }
    
    return answer;
}
