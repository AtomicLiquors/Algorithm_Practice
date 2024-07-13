import java.util.Queue;
import java.util.ArrayDeque;

class Node {
    int r;
    int c;
    int tiles;
    
    Node(int r, int c, int tiles){
        this.r = r;
        this.c = c;
        this.tiles = tiles;
    }
}

class Solution {
    int[] dR = {1,0,-1,0};
    int[] dC = {0,1,0,-1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        Queue<Node> que = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        
        int N = maps.length - 1;
        int M = maps[0].length - 1;
        que.offer(new Node(0, 0, 1));
        
        while(!que.isEmpty()){
            Node curr = que.poll();
            if(curr.r == N && curr.c == M){
                answer = curr.tiles;
                que.clear();
                break;
            }
            
            int nr, nc;
            
            for(int i = 0; i < 4; i++){
                nr = curr.r + dR[i];
                nc = curr.c + dC[i];
                
                if(nr < 0 || nc < 0 || nr > N || nc > M || visited[nr][nc])
                    continue;
                
                visited[nr][nc] = true;
                
                if(maps[nr][nc] == 1)
                    que.offer(new Node(nr, nc, curr.tiles+1));
            }
        }
        
        return answer;
    }
}
