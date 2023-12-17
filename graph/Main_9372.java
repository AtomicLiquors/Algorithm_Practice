package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_9372 {
    static int sum;
    static int targetSum;
    static int[] adjCities, visitCount;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            sum = 0;
            targetSum = 0;
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[N+1];
            adjCities = new int[N+1];
            visitCount = new int[N+1];
            int count = 0;

            int a;
            int b;

            targetSum = (N * (N + 1) ) / 2;

            for (int i = 0; i < M; i++) {
               st = new StringTokenizer(br.readLine());
               a = Integer.parseInt(st.nextToken());
               b = Integer.parseInt(st.nextToken());
               graph[a].add(b);
               graph[b].add(a);
               adjCities[a]++;
               adjCities[b]++;
            }


            System.out.println(answer);
        }

        br.close();
    }

    static void backtrack(int city){

        if(visitCount[city] == 0) sum++;
        visitCount[city]++;

        for (int i = 0; i < adjCities[i]; i++) {

        }
        visitCount[city]--;
        if(visitCount[city] == 0) sum--;

    }
}
