import java.util.Scanner;

public class Main_13023_ABCDE_최효빈 {
    //틀렸습니다

    static class Node{
        int vertex;
        Node link;

         public  Node(int vertex, Node link){
            super();
            this.vertex = vertex;
            this.link = link;
        }
    }


    static Node[] adjList;
    static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        adjList = new Node[V];

        int from, to;
        for (int i = 0; i < E; i++) {
            from = sc.nextInt();
            to = sc.nextInt();

            adjList[from] = new Node(to, adjList[from]);
            adjList[to] = new Node(from, adjList[to]);
        }

        for (int i = 0; i < V; i++) {
            //오답 이유 : V 이하의 모든 인덱스에 대해서 dfs를 수행해야 한다.
            dfs(i, new boolean[V], 1);
        }

        System.out.println(0);
    }

    private static void dfs(int idx, boolean[] visited, int cnt){
        //
        //System.out.print(idx + " ");
        //System.out.print((cnt > 4? "cnt: " + cnt :"") + " " );
        if(cnt == 5){
            System.out.println(1);
            System.exit(0);
        }
        visited[idx] = true;
        for(Node temp = adjList[idx]; temp!= null; temp = temp.link){
            if(!visited[temp.vertex]){
                dfs(temp.vertex, visited, cnt+1);
            }
        }
        visited[idx] = false;

    }
}
