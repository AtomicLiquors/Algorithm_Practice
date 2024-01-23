package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_15685 {
    // 주어지는 수와 입력값이 x, y다.
    static boolean[][] map;
    static int N, maxR, minR, maxC, minC;

    static int[] dR = {0, -1, 0, 1};
    static int[] dC = {1, 0, -1, 1};

    static Deque<int[]> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new boolean[101][101];

        StringTokenizer st;
        int x, y, d, g;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            System.out.println();
            System.out.println("new curve");
            createCurve(x, y, d, g);
        }

        System.out.println(Arrays.deepToString(map));
    }

    static void createCurve(int x, int y, int d, int g){
        int nx = x + dC[d];
        int ny = y + dR[d];
        map[y][x] = true;
        map[ny][nx] = true;

        maxR = Math.max(y, ny);
        maxC = Math.max(x, nx);

        minR = Math.min(y, ny);
        minC = Math.min(x, nx);

        dq.offer(new int[]{ny, nx});
        dq.offer(new int[]{y, x});


        for (int i = 0; i < g; i++) {
            int[] anchor = dq.poll();
            int anchorR = anchor[0];
            int anchorC = anchor[1];
            System.out.println("anchor: " + anchor[0] + " " +anchor[1]);

            System.out.println(i + "i");
            System.out.println((int)Math.pow(2, i) + " dots");
            for(int j = 1; j <= (int)Math.pow(2, i); j++){
                int[] curr = dq.poll();

                System.out.println("curr: " + curr[0] + " " +curr[1]);
                int[] next = {
                    anchorR + (curr[1] - anchorC),
                    anchorC - (curr[0] - anchorR)
                };

                map[next[0]][next[1]] = true;
                System.out.println("marked: " + next[0] + " " +next[1]);


                maxR = Math.max(maxR, next[0]);
                maxC = Math.max(maxC, next[1]);

                minR = Math.min(minR, next[0]);
                minC = Math.min(minC, next[1]);

                dq.offer(next);
                dq.offer(curr);
            }
        }
        dq.clear();
    }
}
