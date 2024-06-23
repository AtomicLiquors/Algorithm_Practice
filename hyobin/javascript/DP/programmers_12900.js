function solution(n) {
        const dp = [1, 1];
        
        for(let idx = 2; idx <= n; idx++){
            dp[idx] = (dp[idx-1] + dp[idx-2]) % 1000000007;
        }
        
        return dp[n];
}
