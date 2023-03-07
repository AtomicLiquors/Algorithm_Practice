import sun.lwawt.macosx.CSystemTray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1987_알파벳_최효빈 {

    static int[] dR = {0, 1, 0, -1};
    static int[] dC = {1, 0, -1, 0};

    static int R, C, max;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {

                map[i][j] = str.charAt(j) - 65;
                //입력 알파벳을 0으로 시작하는 인덱스로 변경
            }
        }
        //System.out.println(Arrays.deepToString(map));

        visited = new boolean[26];
        move(0, 0, 1);
        System.out.println(max);
    }

    static void move(int r, int c, int cnt){
        //이동 횟수를 cnt로 전달
        visited[map[r][c]] = true;
        max = Math.max(max, cnt);

        for (int i = 0; i < 4; i++) {
            //4방탐색
            int nextR = r  + dR[i];
            int nextC = c  + dC[i];
            if(nextR >= 0 && nextC >= 0 && nextR < R && nextC < C){
                if(!visited[map[nextR][nextC]]){
                    move(nextR, nextC, cnt+1);
                    //재귀호출
                    visited[map[nextR][nextC]] = false;
                    //종료 시 방문 체크 해제
                }
            }
        }
    }
}