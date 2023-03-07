import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Clone {


    static class Node{
        int vertex;
        Node link;

        public  Node(int vertex, Node link){
            super();
            this.vertex = vertex;
            this.link = link;
        }
    }

    static int V;
    static Node[] adjList;
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        adjList = new Node[V];
        visited = new boolean[V];


    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;


        while (!q.isEmpty()){
            int curr = q.poll();
            for (Node temp = adjList[curr]; temp != null; temp = temp.link) {
                if(!visited[temp.vertex]){
                    q.offer(temp.vertex);
                    visited[temp.vertex] = true;
                }
            }
        }
    }

    static void dfs(int cnt, boolean[] visited){


    }


}
