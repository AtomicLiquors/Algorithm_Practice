package Z_ETC;

import java.io.*;

import java.util.*;

public class Main_1697_숨바꼭질_최효빈 {

    static class Node{
        int value;
        int level;

        Node(int value, int level){
            this.value = value;
            this.level = level;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = K;

        Queue<Node> q = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        Node curr = new Node(N, 0);
        int cValue, cLevel;
        q.offer(curr);
        while(!q.isEmpty()){
            curr = q.poll();
            cValue = curr.value;
            cLevel = curr.level;

            visited[cValue] = true;

            //System.out.println("cValue : " + cValue );
            //System.out.println("cLevel : " + cLevel );
            if(cValue == K) {
                System.out.println(cLevel);
                return;
            }
            if(cValue*2 <= 100000 && !visited[cValue*2])
                q.offer(new Node(cValue*2, cLevel+1));
            if(cValue > 0 && !visited[cValue-1])
                q.offer(new Node(cValue-1, cLevel+1));
            if(cValue+1 < 100000 && !visited[cValue+1])
                q.offer(new Node(cValue+1, cLevel+1));
        }
        System.out.println(answer);

        br.close();
    }
}