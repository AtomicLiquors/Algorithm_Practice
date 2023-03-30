package DP.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
//dfs TLE, bfs 시간초과
class Node{
    int r;
    int c;
    int cnt;
    int k;

    public Node(int r, int c, int cnt, int k) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.k = k;
    }
}

public class Main_1600_말이되고픈원숭이_최효빈 {

    static int[] kR = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] kC = {2, 1, -1, -2, -2, -1, 1, 2};

    static int[] dR = {1, 0, -1, 0};
    static int[] dC = {0, 1, 0, -1};

    static int[][] map;

    static int W, H, endR, endC;
    static Queue<Node> q;


    public static void main(String[] args) throws IOException{
        //시간 초과.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        endR = H-1;
        endC = W-1;

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) - 1;

                //장애물은 0, 빈 칸은 -1로 표현 -> 끝점에 도달하지 못했다면 -1이 출력되게끔
            }
        }

        // dfs(0, 0, 0, K);
        q = new ArrayDeque<>();
        q.offer(new Node(0, 0, 0, K));


        int r, c, cnt, k;
        while (!q.isEmpty()){

            Node curr = q.poll();
            r = curr.r;
            c = curr.c;
            cnt = curr.cnt;
            k = curr.k;

            //끝점!=-1이고 cnt > 끝점+2일 때 끝내고 싶다.

            if(isBlocked(r, c)) continue;

            if(map[r][c] == -1 || map[r][c] > cnt){//빈칸이라면, 또는 이전 이동횟수보다 지금 이동횟수가 적다면
                map[r][c] = cnt;
            }else{
                //이전에 기록된 이동 횟수보다 지금 이동횟수가 더 많은데다(또는 어차피 똑같은데다)
                if(k==0) continue;
                // 더 빨리 갈 수 있는 방법이 남아있지도 않다면(k==0) 더이상 탐색할 필요가 없다.
                if(cnt - map[r][c] >= 2) continue;
                //k를 써서 2칸을 건너뛰더라도 무조건 느린 경우 더이상 탐색할 필요가 없다.
            }

            if(r==endR && c==endC) continue;
            if(map[endR][endC] > 0 && map[endR][endC] + 2 <= cnt) break;
            if(k!=0) {
                for (int i = 0; i < 8; i++) {
                    q.offer(new Node(r+kR[i], c+kC[i], cnt+1, k-1));
                }
            }
            for (int i = 0; i < 4; i++) {
                q.offer(new Node(r+dR[i], c+dC[i], cnt+1, k));
            }


        }


        System.out.println(map[endR][endC]);

    }

    static boolean isBlocked(int r, int c) {
        if(r >= H || r < 0 || c < 0 || c >= W) return true;
        else if(map[r][c] == 0) return true;
        return false;
    }

    static void dfs(int r, int c, int cnt, int k) {

        if(isBlocked(r, c)) return;

        if(map[r][c] == -1 || map[r][c] > cnt){//빈칸이라면, 또는 이전 이동횟수보다 지금 이동횟수가 적다면
            map[r][c] = cnt;
        }else{
            //이전에 기록된 이동 횟수보다 지금 이동횟수가 더 많은데다(또는 어차피 똑같은데다)
            if(k==0) return;
            // 더 빨리 갈 수 있는 방법이 남아있지도 않다면(k==0) 더이상 탐색할 필요가 없다.
            if(cnt - map[r][c] >= 2) return;
            //k를 써서 2칸을 건너뛰더라도 무조건 느린 경우 더이상 탐색할 필요가 없다.
        }

        //System.out.printf("r,c : %d, %d, cnt : %d, k : %d\n",r, c, cnt, k);
        if(r==endR && c==endC) return;
        if(k!=0) {
            for (int i = 0; i < 8; i++) {
                dfs(r+kR[i], c+kC[i], cnt+1, k-1);
            }
        }
        for (int i = 0; i < 4; i++) {
            dfs(r+dR[i], c+dC[i], cnt+1, k);
        }

    }

}
