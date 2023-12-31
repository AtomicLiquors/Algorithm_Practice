// 상근이의 여행
// 스택을 이용한 최소 신장 트리.

import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i=0; i<T; i++) {
            
            Stack<Integer> stack = new Stack<>();
            
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            
            boolean[] visited = new boolean[N+1];
            List<Integer>[] link = new ArrayList[N+1];
            for (int j=1; j<=N; j++) link[j] = new ArrayList<>();
            
            
            for (int j=0; j<M; j++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);
                link[u].add(v);
                link[v].add(u);
            }
            
            stack.push(1);
            int count = 0;
            
            while (!stack.isEmpty()) {
                
                int now = stack.pop();
                visited[now] = true;
                
                for (int next : link[now]) {
                    if (!visited[next]) {
                        visited[next] = true;
                        count++;
                        stack.push(next);
                    }
                }
            }
            
            System.out.println(count);
        }
        
        br.close();
    }
}

// // https://stonage.tistory.com/209
