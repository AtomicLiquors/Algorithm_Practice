// 방문 체크를 큐에 집어넣는 시점에 할 것.
// BFS while문 종료를 위해 큐 비워줄 것.

import java.util.*;

class programmers_159993 {
    int[] dR = {1, 0, -1, 0};
    int[] dC = {0, -1, 0, 1};
    int V, H;
    boolean open, visited[][];
    Queue<int[]> q;
    
    public int solution(String[] maps) {
        int answer = -1;
        
        V = maps.length;
        H = maps[0].length();
        int limit = V * H * 2;
        
        open = false;
        visited = new boolean[V][H];
        
        q = new ArrayDeque<>();

        boolean found = false;
        
        int i = -1;
        while(++i < V && !found){
            for(int j = 0; j < H; j++){
                if(maps[i].charAt(j) == 'S'){
                    q.offer(new int[]{i, j, 0});
                    found = true;
                    break;
                }
            }
        }
        
        
        while(!q.isEmpty()){ 
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            int cnt = curr[2];
            if(cnt > limit) break;
            
            //visited[r][c] = true;
            
            int nr, nc;
            for(int dir = 0; dir < 4; dir++){
                nr = r + dR[dir];
                nc = c + dC[dir];
                if(isOuttaBound(nr, nc) || visited[nr][nc]) 
                    continue;
                
                char mark = maps[nr].charAt(nc);
                
                if(mark == 'X') 
                    continue;
                else if(mark == 'L' && !open){
                    triggerLever();
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, cnt+1});
                    break;
                }else if(mark == 'E' && open){
                    answer = cnt+1;
                    q.clear();
                    break;
                }else{
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc, cnt+1});
                }
            }
        }
        
        return answer;
    }
    
    boolean isOuttaBound(int r, int c){
        return r < 0 || c < 0 || r >= V || c >= H;
    }
    
    void triggerLever(){
        open = true;
        q.clear();
        visited = new boolean[V][H];
    }
}
