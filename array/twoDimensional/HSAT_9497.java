package array.twoDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class HSAT_9497 {

    static int[] dR = {0,0,-1,1};
    static int[] dC = {-1,1,0,0};

    static int N, areas, map[][], answer[][];
    static boolean found, collection[];
    //backtracking
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        answer = new int[N][N];
        collection = new boolean[N+1];

        areas = 0;
        sudoku(0,0, 0, 0);

        System.out.println(
        Arrays.deepToString(answer));
    }

    static int[] findNext(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(answer[i][j] == 0)
                    return new int[]{i, j};
            }
        }

        return null;
    }

    static void sudoku(int r, int c, int id, int cnt){
        if(cnt == N){
            if(++areas == N){
                found = true;
                return;
            }
            int[] next = findNext();
            if(findNext() != null)
                sudoku(next[0], next[1], id+1, 0);
        }
        int nr, nc;
        for (int dir = 0; dir < 4; dir++) {
            if(found)
                break;
            nr = r + dR[dir];
            nc = c + dC[dir];

            if(isInBound(nr, nc) && answer[nr][nc] == 0) {
                answer[nr][nc] = id;
                collection[map[nr][nc]] = true;
                sudoku(nr, nc, id, cnt + 1);
                if(found)
                    break;
                answer[nr][nc] = 0;
                collection[map[nr][nc]] = false;
            }
        }

    }

    static boolean isInBound(int r, int c){
        return r >= 0 && c >= 0 && r < N && c < N;
    }
}
