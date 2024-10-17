/*
class Programmers_43162 {
    
    int[] parents;
    int answer = 0;
    
    public int solution(int n, int[][] computers) {
        final int N = computers.length;
        answer = N;
        
        parents = new int[N];
        
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i != j && computers[i][j] == 1)
                    union(i, j);
            }
        }
        
        return answer;
    }
    
    int findSet(int a){
        if(parents[a] == a)
            return a;
        return parents[a] = findSet(parents[a]);
    }
    
    void union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        
        if(aRoot != bRoot){
            parents[bRoot] = aRoot;
            answer--;
        } 
    }
}
 */
