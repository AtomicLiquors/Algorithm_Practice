package graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Node{
    int value;
    int cnt;

    public Node(int value, int cnt){
        this.value = value;
        this.cnt = cnt;
    }
}

public class Main_16953_AtoB {
    static int A, B;

    static int limitA = (int)Math.pow(10, 9) / 2;
    static int limitB = (int)Math.pow(10, 8);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.nextInt();
        B = sc.nextInt();

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(A, 1));

        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.value == B){
                System.out.println(curr.cnt);
                return;
            }

            if(curr.value <= limitA)
                q.offer(new Node(curr.value * 2, curr.cnt + 1));
            if(curr.value < limitB)
                q.offer(new Node(curr.value * 10 + 1, curr.cnt + 1));
        }
        System.out.println(-1);
    }
}
