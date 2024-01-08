// 이차원 배열 대각선 순회
function solution(board, k) {
    var answer = 0;
    
    const rows = board.length;
    const cols = board[0].length;
    
    for(let i = 0; i < rows; i++){
        for(let j = 0; j < cols; j++){
            if( i + j <= k) answer += board[i][j];
        }
    }
    return answer;
    
}

/* reduce 이용 */
/*
function solution(board, k) {
  return board.reduce(
    (total, row, i) => total + row.reduce((prev, num, j) => (i + j <= k ? prev + num : prev), 0),
    0,
  );
}
*/
