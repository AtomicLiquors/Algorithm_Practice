import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Node> q = new ArrayDeque<>();

        int value = Integer.parseInt(br.readLine());

        q.offer(new Node(value, 0));
        int cnt = 0;
        while (!q.isEmpty()){
            Node curr = q.poll();
            if(curr.value == 1){
                cnt = curr.level;
                break;
            }

            if(curr.value % 3 ==0) q.offer(new Node(curr.value/3, curr.level+1));
            if(curr.value % 2 ==0) q.offer(new Node(curr.value/2, curr.level+1));
            q.offer(new Node(curr.value-1, curr.level+1));
        }
        System.out.println(cnt);
    }
}

class Node{
    int value;
    int level;

    public Node(int value, int level) {
        super();
        this.value = value;
        this.level = level;
    }
}
