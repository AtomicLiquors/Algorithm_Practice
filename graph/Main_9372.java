package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시간 초과
public class Main_9372 {

    static int N, M, parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<int[]> q;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parents = new int[N+1];
            q = new ArrayDeque<>();
            int a;
            int b;

            makeSet();

            for (int i = 0; i < M; i++) {
               st = new StringTokenizer(br.readLine());
               a = Integer.parseInt(st.nextToken());
               b = Integer.parseInt(st.nextToken());
               q.offer(new int[]{a, b});
            }

            int answer = 0;

            while(!q.isEmpty()){
                int[] curr = q.poll();
                if(union(curr[0], curr[1]))
                    answer++;
            }


            System.out.println(answer);
        }

        br.close();
    }

    static void makeSet(){
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot)
            return false;
        else{
            parents[aRoot] = bRoot;
            return true;
        }
    }

    static int findSet(int i) {
        if(parents[i] == i)
            return i;
        return parents[i] = findSet(parents[i]);
    }
}
