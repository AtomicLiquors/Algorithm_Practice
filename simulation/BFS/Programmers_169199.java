import java.util.*;

class Solution {
    int N;
    int M;
    int[][] visited;
    int[] dR = {0,0,-1,1};
    int[] dC = {-1,1,0,0};
    
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        visited = new int[N][M];
        
        Queue<int[]> que = new ArrayDeque<>();
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i].charAt(j) == 'R'){
                    que.offer(new int[]{i, j, 0});
                    break;
                }
            }
            if(!que.isEmpty())
                break;
        }
        
        while(!que.isEmpty()){

            int[] curr = que.poll();
            
            int r = curr[0];
            int c = curr[1];
            int moves = curr[2];
            
            if(board[r].charAt(c) == 'G')
                return moves;
            
            int nr, nc;
            for(int dir = 0; dir < 4; dir++){
                if( ( visited[r][c] & (1 << dir) ) > 0 )
                    continue;
                
                visited[r][c] = visited[r][c] | (1 << dir);
                
                nr = r;
                nc = c;
                
                while(isInBound(nr, nc) && board[nr].charAt(nc) != 'D'){
                    nr += dR[dir];
                    nc += dC[dir];
                }
                
                nr -= dR[dir];
                nc -= dC[dir];
                
                if(nr == r && nc == c)
                    continue;
                
                que.offer(new int[]{nr, nc, moves+1});
            }
        }
        
        
        return -1;
    }
    
    
    boolean isInBound(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}
