package DP;

class Programmers_67259 {

    int N;
    int[][] board;
    int[][][] dp;
    int[] dR = {0,1,0,-1};
    int[] dC = {1,0,-1,0};

    public int solution(int[][] board) {

        this.board = board;

        N = board.length;
        dp = new int[N][N][4];

        traverse(0, 0, 0, 0);
        traverse(0, 0, 1, 0);

        int answer = Integer.MAX_VALUE;


        for(int value : dp[N-1][N-1]){
            answer = ( value == 0 ? answer : Math.min(answer, value));
        }
        return answer;
    }

    public void traverse(int r, int c, int dir, int sum){

        int curr = dp[r][c][dir];

        if(curr == 0 || curr > sum)
            dp[r][c][dir] = sum;
        else
            return;

        int nr, nc, nSum;
        for(int d = 0; d < 4; d++){

            nr = r + dR[dir];
            nc = c + dC[dir];

            if(nr < 0 || nc < 0 || nr >= N || nc >= N || board[r][c] == 1)
                continue;

            nSum = sum + (d == dir ? 100 : 600);

            traverse(nr, nc, d, nSum);
        }
        return;
    }
}
