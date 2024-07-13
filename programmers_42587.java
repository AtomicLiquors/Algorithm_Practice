// 프로세스
import java.util.*;

class Node {
    int priority;
    int idx;

    public Node(int priority, int idx){
        this.priority = priority;
        this.idx = idx;
    }
}

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Node> que = new ArrayDeque<>();
        int[] cache = new int[10];
        int max = 0;

        for(int i = 0; i < priorities.length; i++){
            Node curr = new Node(priorities[i], i);
            max = Math.max(max, priorities[i]);
            cache[priorities[i]]++;
            que.offer(curr);
        }

        int cnt = 0;

        while(!que.isEmpty()){
            Node curr = que.poll();

            if(curr.priority < max){
                que.offer(curr);
            }else{
                cnt++;
                if(curr.idx == location){
                    break;
                }

                cache[max]--;
                while(max >= 0 && cache[max] == 0)
                    max--;
            }

        }

        return cnt;
    }
}
