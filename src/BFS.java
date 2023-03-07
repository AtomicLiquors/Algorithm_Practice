import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {

    }

    static void bfs() {

        Queue<Integer> queue = new ArrayDeque();
        queue.offer(1);

        while(!queue.isEmpty()){
            int t = queue.poll();

            queue.offer(1);
        }

        //자식 노드에 접근하는 방법?

    }
}
