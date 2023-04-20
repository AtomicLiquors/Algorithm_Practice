package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class Traverse {
    public static void main(String[] args) {

    }
/*
    public void bfs0(){
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(1);

        int current = 0, size, level = 0;
        while(!queue.isEmpty()){

            size = queue.size();
            System.out.print("level " + level + " : ");
            while(--size>=0){
                current = queue.poll();
                System.out.print(nodes[current]+" ");
                if(current*2 <= lastIndex)
                    queue.offer(current*2);
                if((current*2+1) <= lastIndex)
                    queue.offer(current*2+1);
            }
        }
    }


    public void dfsByPreOrder(){
        System.out.println("PreOrder : ");
        dfsByPreOrder(1);
        System.out.println();
    }

    private void dfsByPreOrder(int current){
        System.out.println(nodes[current]);

        if(current*2 <= lastIndex)
            queue.offer(current*2);
        if((current*2+1) <= lastIndex)
            queue.offer(current*2+1);
    }*/
}
