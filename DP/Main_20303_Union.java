package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_20303_Union {
    static int[] roots, candies, friends;

    // 정수 오버플로우는 날 수가 없다 : 애들이 총 30000명, 사탕 수가 인당 10000개니까 30000 * 10000 = 사탕을 다 뺏어도 3억개가 맥시멈이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        candies = new int[N+1];
        roots = new int[N+1];
        friends = new int[N+1];

        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
            roots[i] = i;
            friends[i] = 1;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        boolean[] visited = new boolean[N+1];

        List<Integer> friendSumList = new ArrayList<>();
        List<Integer> candySumList = new ArrayList<>();

        friendSumList.add(0);
        candySumList.add(0);
        int listsSize = 0;

        for (int i = 1; i <= N; i++) {
            int root = roots[i];
            if(!visited[root]){
                visited[root] = true;
                friendSumList.add(friends[root]);
                candySumList.add(candies[root]);
                listsSize++;
            }
        }

        int[][] DP = new int[listsSize+1][K];
        int answer = 0;
        for (int i = 1; i <= listsSize; i++) {
            for (int j = friendSumList.get(i); j < K; j++) {
                DP[i][j] = Math.max(DP[i-1][j], DP[i-1][j - friendSumList.get(i)] + candySumList.get(i));
                answer = Math.max(DP[i][j], answer);
            }
            // 모든 경우에 대해 조회하는 게 맞나? 더하지 말아야 할 조합을 더하지는 않는가?
        }
        System.out.println(answer);
    }

    static int findSet(int a){
        if(roots[a] == a)
            return a;
        return roots[a] = findSet(roots[a]);
    }


    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        candies[aRoot] += candies[bRoot];
        friends[aRoot] += friends[bRoot];
        roots[bRoot] = aRoot;
        return true;
    }
}
