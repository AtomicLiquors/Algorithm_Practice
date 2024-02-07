package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Camera {
    int r;
    int c;
    int type;

    Camera(int r, int c, int type){
        this.r = r;
        this.c = c;
        this.type = type;
    }
}

public class Main_15683 {

    static int N, M;
    static int[][] map;
    static int[][] watched;
    static int answer;
    static int current;
    static int camCount;
    static List<Camera> cams;

    static int[] dR = {-1, 0, 1, 0};
    static int[] dC = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = N * M;

        cams = new ArrayList<>();

        Queue<int[]> que = new ArrayDeque<>();
        map = new int[N][M];
        watched = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0){
                    answer--;
                    if(map[i][j] <= 4)
                        cams.add(new Camera(i, j, map[i][j]));
                    else if(map[i][j] == 5)
                        que.offer(new int[]{i, j});
                }
            }
        }


        current = answer;
        while(!que.isEmpty()){
            int[] curr = que.poll();
            for (int i = 0; i < 4; i++) {
                record(curr[0], curr[1], i, true);
            }
        }
        answer = Math.min(current, answer);

        camCount = cams.size();

        recur(0);

        System.out.println(answer);
    }

    static void recur(int idx){
        if(idx == camCount){
            answer = Math.min(current, answer);
            return;
        }
        Camera cam = cams.get(idx);

        switch(cam.type){
            case 1:
                for (int i = 0; i < 4; i++) {
                    record(cam.r, cam.c, i, true);
                    recur(idx + 1);
                    record(cam.r, cam.c, i, false);
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    record(cam.r,cam.c,i, true);
                    record(cam.r,cam.c,i+2, true);
                    recur(idx + 1);
                    record(cam.r,cam.c,i, false);
                    record(cam.r,cam.c,i+2, false);
                }
                break;
            case 3:
                record(cam.r,cam.c,0, true);
                for (int i = 1; i < 5; i++) {
                    record(cam.r,cam.c,i%4, true);
                    recur(idx + 1);
                    record(cam.r,cam.c,i-1, false);
                }
                record(cam.r,cam.c,0, false);
                break;
            case 4:
                record(cam.r,cam.c,0, true);
                record(cam.r,cam.c,1, true);
                for (int i = 2; i < 6; i++) {
                    record(cam.r,cam.c,i%4, true);
                    recur(idx + 1);
                    record(cam.r,cam.c,i-2, false);
                }
                record(cam.r,cam.c,0, false);
                record(cam.r,cam.c,1, false);
                break;
        }

    }




    static void record(int r, int c, int dir, boolean mod){

        int nr = r + dR[dir];
        int nc = c + dC[dir];
        while(nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] != 6){
            if(map[nr][nc] == 0 ){
                if(mod){
                    if(watched[nr][nc] == 0) current--;
                    watched[nr][nc]++;
                }else{
                    watched[nr][nc]--;
                    if(watched[nr][nc] == 0) current++;
                }
            }
            nr += dR[dir];
            nc += dC[dir];
        }

    }
}
