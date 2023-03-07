import java.util.ArrayDeque;
import java.util.Queue;

public class CompleteBinaryTree<T> {

    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public CompleteBinaryTree(int size){
        SIZE = size;
        nodes = new Object[size+1];
    }

    private boolean isFull(){
        return lastIndex == SIZE;
    }

    public void add(T e){
        if(isFull()) return;
        nodes[++lastIndex] = e;
    }

    public void bfs(){
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(1); // 루트노드부터

        int current = 0;
        while(!queue.isEmpty()){ // 큐에 대기중인 순서대로 노드를 처리
            current = queue.poll();
            System.out.println(nodes[current]);

            //현재 노드의 자식노드들을 큐에 넣어 순서를 기다리게 하기
            //완전 이진 트리니까 자식이 최대 둘인 상황...!
            if(current * 2 <= lastIndex) queue.offer(current * 2);
            if( (current * 2 + 1 )<= lastIndex) queue.offer(current * 2+1);
        }
    }


}
