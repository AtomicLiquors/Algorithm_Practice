function solution(keyinput, board) {
    var answer = [];
    const width = Math.floor(board[0] / 2);
    const height = Math.floor(board[1] / 2);
    let r = 0;
    let c = 0;
    
    const dR = new Map();
    const dC = new Map();
    dR["left"] = 0;
    dR["right"] = 0;
    dR["up"] = 1;
    dR["down"] = -1;
    
    dC["left"] = -1;
    dC["right"] = 1;
    dC["up"] = 0;
    dC["down"] = 0;
    
    for(const key of keyinput){
        r += dR[key];
        c += dC[key];
        if( r > height ) r = height;
        else if ( r < -height ) r = -height;
        if( c > width ) c = width;
        else if ( c < -width ) c = -width;
    }
    answer.push(c);
    answer.push(r);
    return answer;
}

// 모범답안
/*
function solution(keyinput, board) {
    let res = [0,0];
    for (let p of keyinput) {
        switch(p){
            case 'left': if (-res[0] < board[0]/2-1) res[0]--; break;
            case 'right': if (res[0] < board[0]/2-1) res[0]++; break;
            case 'up': if (res[1] < board[1]/2-1) res[1]++; break;
            case 'down': if (-res[1] < board[1]/2-1) res[1]--; break;
        }
    }
    return res;
}
*/
