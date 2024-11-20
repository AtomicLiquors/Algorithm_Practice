package combinatorics.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15686 {

    static int N, M, houseLength, storeLength, map[][], answer = Integer.MAX_VALUE;

    static boolean[] isSelected;
    static List<int[]> storeLocations, houseLocations;

    public static void main(String[] args) throws IOException {

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
            int currentCityChickenDist = 0;
            for (int hIdx = 0; hIdx < houseLength; hIdx++) {
                int minDist = Integer.MAX_VALUE;
                int currentDist;
                for (int sIdx = 0; sIdx < storeLength; sIdx++) {
                    if(isSelected[sIdx]){
                        int[] house = houseLocations.get(hIdx);
                        int houseR = house[0];
                        int houseC = house[1];

                        int[] store = storeLocations.get(sIdx);
                        int storeR = store[0];
                        int storeC = store[1];

                        currentDist = Math.abs(houseR - storeR) + Math.abs(houseC - storeC);
                        minDist = Math.min(currentDist, minDist);
                    }
                }
                currentCityChickenDist += minDist;

            }
            answer = Math.min(currentCityChickenDist, answer);
            return;
        }

        if(cnt < M){
            isSelected[idx] = true;
            subset(cnt+1, idx+1);
            isSelected[idx] = false;
        }
        subset(cnt, idx+1);
    }

}
