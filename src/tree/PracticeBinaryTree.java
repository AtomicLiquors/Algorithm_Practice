import java.util.ArrayDeque;
import java.util.Queue;

public class PracticeBinaryTree<T> {

    private Object[] nodes;
    private final int SIZE;
    private int lastIndex;

    public PracticeBinaryTree(int size){
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
        //노드 번호를 저장
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);

        int curr = 0;
        while(!q.isEmpty()){
            curr = q.poll();
            System.out.println(nodes[curr]);
            if(curr*2<=lastIndex) q.offer(curr*2);

            /*
            curr = q.poll(); //현재 탐색해야 하는 노드의 번호
            System.out.println(nodes[curr]);

            //현재 노드의 자식 노드를 큐에 넣어 순서를 기다리게 하기.
            if((curr * 2)<=lastIndex) q.offer(curr * 2);
            if((curr * 2 + 1)<=lastIndex) q.offer(curr * 2 + 1);
*/
        }
    }

    public void dfsByPreOrder(){
        dfsByPreOrder(1);
    }

    public void dfsByPreOrder(int current){
        System.out.println(nodes[current]);
        if(current*2 <= lastIndex) dfsByPreOrder(current*2);
        if(current*2+1 <= lastIndex) dfsByPreOrder(current*2+1);
    }


    public void dfsByInOrder(int current){
        if(current*2 <= lastIndex) dfsByInOrder(current*2);
        System.out.println(nodes[current]);
        if(current*2+1 <= lastIndex) dfsByInOrder(current*2+1);
    }

    public void dfsByPostOrder(int current){

        if(current*2 <= lastIndex) dfsByPostOrder(current*2);
        if(current*2+1 <= lastIndex) dfsByPostOrder(current*2+1);
        System.out.println(nodes[current]);
    }

}
