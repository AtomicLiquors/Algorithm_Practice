package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16919 {

    static Queue<int[]> bombs;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] map = new char[R][C];
        bombs = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
                if(map[i][j] == 'O'){
                    bombs.offer(new int[]{i, j});
                }
            }
        }

        if(N < 2)
            printMap(map);
        else if(N % 2 == 0)
            printMap(createFullMap(R, C));
        else if(N % 4 == 1)
            printMap(map);
        else
            printMap(createInvertMap(R, C));


        br.close();
    }

    static void printMap(char[][] map){
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (char bomb : row) {
                sb.append(bomb);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static char[][] createFullMap(int r, int c){

        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            Arrays.fill(map[i], '0');
        }

        return map;
    }

    static char[][] createInvertMap(int R, int C){
        char[][] map = createFullMap(R, C);

        int[] dR = {0, 0, -1, 1};
        int[] dC = {-1, 1, 0, 0};

        while(!bombs.isEmpty()){
            int[] bomb = bombs.poll();

            int r = bomb[0];
            int c = bomb[1];
            map[r][c] = '.';

            int nr, nc;
            for (int dir = 0; dir < 4; dir++) {
                nr = r + dR[dir];
                nc = c + dC[dir];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C)
                    continue;

                map[nr][nc] = '.';
            }
        }

        return map;
    }
}
