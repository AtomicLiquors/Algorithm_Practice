package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_20057 {
    static int N;
    static int[][] map;
    static int[] dR = {0, 1, 0, -1};
    static int[] dC = {-1, 0, 1, 0};
    static int[] ratios = {5, 10, 7, 2, 1};
    static int[] acrossOffset = {0, 1, 1, 2, 1};
    static int[] straightOffset = {2, 1, 0, 0, -1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int dir = 0;
        int r = N/2;
        int c = r;
        int mark = 0;
        int nr = r;
        int nc = c;

        int end = N-1;
        answer = 0;

        for (int dist = 1; dist < N; dist++) {
            for (int i = 0; i < (dist == end ? 3 : 2); i++) {
                for (int j = 0; j < dist; j++) {
                    int cache = map[nr][nc];
                    map[nr][nc] = 0;
                    nr += dR[dir];
                    nc += dC[dir];
                    map[nr][nc] += cache;
                    scatter(nr, nc, dir);
                }
                dir = (dir + 1) % 4;
            }
        }

        System.out.println(answer);
    }

    static void scatter(int sr, int sc, int dir){
        int totalSand = map[sr][sc];
        int totalScatteredSand = 0;

        int[] sides = new int[]{0, 0};
        for (int i = 0; i < 5; i++){
            // 위치를 찍는다.
            int pointR = sr + dR[dir] * straightOffset[i];
            int pointC = sc + dC[dir] * straightOffset[i];
            int amount = (totalSand * ratios[i]) / 100;

            if(i==0){
                map[sr][sc] -= amount;
                totalScatteredSand += amount;
                moveSand(pointR, pointC, amount);
                continue;
            }

            sides[0] = (dir - 1);
            if(sides[0] < 0) sides[0] += 4;
            sides[1] = (dir + 1) % 4;

            for (int j = 0; j < 2; j++) {
                // 위치를 찍는다.
                int targetR = pointR + dR[sides[j]] * acrossOffset[i];
                int targetC = pointC + dC[sides[j]] * acrossOffset[i];

                map[sr][sc] -= amount;
                totalScatteredSand += amount;
                moveSand(targetR, targetC, amount);
            }
        }

        //알파를 더한다.
        int alphaR = sr + dR[dir];
        int alphaC = sc + dC[dir];
        map[sr][sc] = 0;
        moveSand(alphaR, alphaC, totalSand - totalScatteredSand);
    }

    static void moveSand(int r, int c, int amount){
        if(isOutOfBound(r, c))
            answer += amount;
        else
            map[r][c] += amount;
    }

    static boolean isOutOfBound(int r, int c){
        return r < 0 || c < 0 || r >= N || c >= N;
    }
}
