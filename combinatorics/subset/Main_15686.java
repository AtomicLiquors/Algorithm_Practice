package combinatorics.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686 {

    static int N, M, houseLength, storeLength, map[][], answer = Integer.MAX_VALUE;
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};
    static boolean[] isSelected;
    static List<int[]> storeLocations, houseLocations;
    static Queue<int[]> marked = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        // 틀린 답이 뜨는 이유를 찾아라.
        // r, c가 가게를 찾지 못하면 distance가 0이 될 수 있다.
        // 가게를 똑바로 복구하지 않았다면 가게를 찾지 못했을 수 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        houseLocations = new ArrayList<>();
        storeLocations = new ArrayList<>();

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 2)
                    storeLocations.add(new int[]{r, c});
                else if(map[r][c] == 1)
                    houseLocations.add(new int[]{r, c});
            }
        }

        houseLength = houseLocations.size();
        storeLength = storeLocations.size();
        isSelected = new boolean[storeLength];

        subset(0,0);

        System.out.println(answer);
    }

    static void subset(int cnt, int idx){
        if(idx == storeLength){
            if(cnt == 0)
                return;

            for (int i = 0; i < storeLength; i++) {
                if(!isSelected[i])
                    removeStore(i);
            }
            findMinimumDistance();
            restoreStores();
            return;
        }

        if(cnt < M){
            isSelected[idx] = true;
            subset(cnt+1, idx+1);
            isSelected[idx] = false;
        }
        subset(cnt, idx+1);
    }

    static void removeStore(int i){
        int[] loc = storeLocations.get(i);
        int r = loc[0];
        int c = loc[1];
        map[r][c] = 0;
        marked.offer(new int[]{r, c});
    }

    static void restoreStores(){
        while(!marked.isEmpty()){
            int[] loc = marked.poll();
            int r = loc[0];
            int c = loc[1];
            map[r][c] = 2;
        }
    }

    static void findMinimumDistance(){
        int regionalChickenDistance = 0;

        for (int i = 0; i < houseLength; i++)
            regionalChickenDistance += getChickenDistance(i);

        answer = Math.min(answer, regionalChickenDistance);
    }

    static int getChickenDistance(int i){
        int[] house = houseLocations.get(i);
        int startR = house[0];
        int startC = house[1];

        int distance = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[N][N];
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{startR, startC, 0});
        visited[startR][startC] = true;

        while(!que.isEmpty()){
            int[] loc = que.poll();
            int r = loc[0];
            int c = loc[1];
            int offset = loc[2];

            if(map[r][c] == 2){
                distance = offset;
                break;
            }


            int nr, nc;
            for (int dir = 0; dir < 4; dir++) {
                nr = r + dR[dir];
                nc = c + dC[dir];

                if(isOuttaBound(nr, nc) || visited[nr][nc])
                    continue;

                visited[nr][nc] = true;
                que.offer(new int[]{nr, nc, offset+1});
            }
        }

        return distance;
    }

    static boolean isOuttaBound(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}
