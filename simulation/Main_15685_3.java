package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_15685_3 {
    // 주어지는 수와 입력값이 x, y다.
    static boolean[][] map;
    static int N;
    static int maxR = 0;
    static int maxC = 0;
    static int minR = Integer.MAX_VALUE;
    static int minC = Integer.MAX_VALUE;
    static int answer = 0;
    static int[] dR = {0, -1, 0, 1};
    static int[] dC = {1, 0, -1, 0};

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

            createCurve(x, y, d, g);
        }
        countSquare();
        System.out.println(answer);

    }

    static void countSquare(){
        for (int i = minR; i < maxR; i++) {
            for (int j = minC; j < maxC; j++) {
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    answer++;
                }
            }
        }
    }

    static void createCurve(int x, int y, int d, int g){
        List<int[]> list = new ArrayList<>();

        int nx = x + dC[d];
        int ny = y + dR[d];
        map[y][x] = true;
        map[ny][nx] = true;

        maxR = Math.max(maxR, Math.max(y, ny));
        maxC = Math.max(maxC, Math.max(x, nx));

        minR = Math.min(minR, Math.min(y, ny));
        minC = Math.min(minC, Math.min(x, nx));

        list.add(new int[]{y, x});
        list.add(new int[]{ny, nx});

        int lastIdx = 1;

        for (int i = 0; i < g; i++) {

            int[] anchor = list.get(lastIdx);
            int currIdx = lastIdx - 1;

//            System.out.println("i : " + i);
//            System.out.println("anchor: " + anchor[0] + " " + anchor[1]);

            while(currIdx >= 0){
                int[] target = list.get(currIdx);

                // System.out.println("target: " + target[0] + " " +target[1]);

                int[] next = new int[]{anchor[0] + (target[1] - anchor[1]),
                        anchor[1] - (target[0] - anchor[0])};

                map[next[0]][next[1]] = true;
                // System.out.println("marked: " + next[0] + " " +next[1]);



                maxR = Math.max(maxR, next[0]);
                maxC = Math.max(maxC, next[1]);

                minR = Math.min(minR, next[0]);
                minC = Math.min(minC, next[1]);
                list.add(next);
                lastIdx++;
                currIdx--;
            }
        }
    }
}
