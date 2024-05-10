package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice {
    //틀렸습니다

//노드에 비해 간선 수가 한정됨 : 인접 리스트
    static int N, M;
    static int result = 0;

    static Node[] campers;
    static boolean[] visited;

    static class Node{
        int value;
        Node link;



        public Node(int value, Node link){
            super();
            this.value = value;
            this.link = link;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", link=" + link +
                    '}';
        }
    }

    //무향 그래프
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campers = new Node[N];

        //dfs : 조건 충족이 불가능할 경우 이전 단계로 돌아가 다시 조건 충족 여부를 탐색

        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            campers[from] = new Node(to, campers[from]);
            campers[to] = new Node(from, campers[to]);
            //무향 그래프 구현
        }

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            dfs(i, new boolean[N], 1);
        }

        System.out.println(0);
    }

    static void dfs(int idx, boolean[] visited, int cnt){
        //이동 횟수를 cnt로 전달
        if(cnt==5){
            System.out.println(1);
            System.exit(0);
        }

        for (Node curr = campers[idx]; curr != null; curr = curr.link) {
              int num = curr.value;
              if(!visited[num]){
                  visited[num] = true;
                  dfs(num, visited,cnt+1);
                  visited[num] = false;
              }
       }
    }
}
