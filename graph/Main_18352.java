package graph;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352 {
    //특정 거리의 도시 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] cities = new ArrayList[N+1];
        int[] citiesCount = new int[N+1];
        int[] dist = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(cities[start] == null)
                cities[start] = new ArrayList<Integer>();

            cities[start].add(end);
            citiesCount[start]++;
        }

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{X, 0});

        while(!que.isEmpty()){
            int[] curr = que.poll();

//            if(curr[1] > K)
//                continue;

            if(dist[curr[0]] <= curr[1])
                continue;
            else
                dist[curr[0]] = curr[1];


            for(int i = 0; i < citiesCount[curr[0]]; i++){
                int next = cities[curr[0]].get(i);

                que.offer(new int[]{next, curr[1] + 1});

            }
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if(dist[i] == K){
                count++;
                System.out.println(i);
            }
        }
        if(count == 0){
            System.out.println(-1);
        }
        br.close();
    }

}