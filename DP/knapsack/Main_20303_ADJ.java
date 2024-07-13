package DP.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int value;
    Node next;

    Node(int value, Node next){
        this.value = value;
        this.next = next;
    }
}

public class Main_20303_ADJ {
    static int[] roots;
    static int[] candies;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        candies = new int[N+1];
        Node[] adjList = new Node[N+1];
        boolean[] visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a] = new Node(b, adjList[a]);
            adjList[b] = new Node(a, adjList[b]);
        }

        List<Integer> friendsNumbers = new ArrayList<>();
        List<Integer> friendsCandies = new ArrayList<>();

        friendsNumbers.add(0);
        friendsCandies.add(0);

        for (int i = 1; i <= M; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            Node curr = adjList[i];

            int friendsSum = 1;
            int candiesSum = candies[curr.value];

            while(curr.next != null){
               curr = curr.next;
               visited[curr.value] = true;
               friendsSum++;
               candiesSum += candies[curr.value];
            }

            friendsNumbers.add(friendsSum);
            friendsCandies.add(candiesSum);
        }

        System.out.println(friendsNumbers);
        System.out.println(friendsCandies);
    }
}
