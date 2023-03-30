package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_연구소_최효빈 {
//정답 불일치 / 디버그 요망
    static int[][] map;

    static int[] dR = {1, -1, 0, 0};
    static int[] dC = {0, 0, 1, -1};

    static int L, M, N;
    static boolean[] isSelected;
    static List<int[]> blanks;
    static List<int[]> viruses;

    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];


        blanks = new ArrayList<>();
        viruses = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==0) blanks.add(new int[]{i, j});
                else if(map[i][j]==2) viruses.add(new int[]{i, j});
            }
        }

        L = blanks.size();
        isSelected = new boolean[L];
        comb(0, 1);

        System.out.println(max);
    }

    static int[][] copy(){
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[i][j] = map[i][j];
            }
        }
        return newMap;
    }

    static void comb(int start, int cnt){
        if(cnt==3){
            //action
            int[][] newMap = copy();
            //맵 복사

            for (int i = 0; i < L; i++) {
                if(isSelected[i])
                    newMap[blanks.get(i)[0]][blanks.get(i)[1]] = 1;
            }
            for (int i = 0; i < viruses.size(); i++) {
                dfs(viruses.get(i)[0], viruses.get(i)[1], newMap);
            }

            int sum=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(newMap[i][j]==0) sum++;
                }
            }
            //0 갯수 세기

            max = Math.max(0, sum);
            return;
        }

        for (int i = start; i < L; i++) {
            isSelected[i] = true;
            comb(i+1, cnt+1);
            isSelected[i] = false;
        }
    }

    static void dfs(int r, int c, int[][] map){
        //델타 탐색
        if(r>=N||r<0||c>=M||c<0) return;
        else if(map[r][c]!=0) return;

        map[r][c] = 2;

        for (int d = 0; d < 4; d++) {
            dfs(r+dR[d], c+dC[d], map);
        }
    }

}
