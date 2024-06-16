function solution(triangle) {
    const dp = Array.from(
        { length: triangle.length }, 
        (_, layer) => Array.from({ length: layer + 1 }, () => 0)
    );
    
    dp[0][0] = triangle[0][0];
    
    let answer = 0;
    let nextLayer;
    const lastLayer = triangle.length - 1;
    
    for(let layer = 0; layer < lastLayer; layer++){
        nextLayer = layer + 1;
        for(let idx = 0; idx < triangle[layer].length; idx++){
            dp[nextLayer][idx] = Math.max(dp[nextLayer][idx], triangle[nextLayer][idx] + dp[layer][idx]);
            dp[nextLayer][idx+1] = triangle[nextLayer][idx+1] + dp[layer][idx];
        }
    }
    
    for(const idx in dp[lastLayer]){
        answer = Math.max(answer, dp[lastLayer][idx]);
    }
    return answer;
}

// 이 코드 분명히 통과됐다더니 왜 다시 제출하니까 실패 뜨냐?

https://stackoverflow.com/questions/78628761/reading-length-property-from-javascript-array-results-in-lower-performance
