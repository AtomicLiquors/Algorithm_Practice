package DivAndConq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1780 {

    static int map[][], answer[] = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recur(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int value : answer) {
            sb.append(value).append('\n');
        }
        System.out.print(sb);
    }

    static void increaseAnswer(int r, int c){
        answer[map[r][c] + 1]++;
    }

    static void recur(int startR, int startC, int size){

        if(size == 1){
            increaseAnswer(startR, startC);
            return;
        }

        int prev = map[startR][startC];
        int endR = startR + size;
        int endC = startC + size;
        boolean isAllEqual = true;

        for (int i = startR; i < endR; i++) {
            for (int j = startC; j < endC; j++) {
                if(map[i][j] != prev){
                    isAllEqual = false;
                    break;
                }
            }
            if(!isAllEqual)
                break;
        }

        if(isAllEqual){
            increaseAnswer(startR, startC);
            return;
        }

        int dividedSize = size / 3;
        for (int i = startR; i < endR; i += dividedSize) {
            for (int j = startC; j < endC; j += dividedSize) {
                recur(i, j, dividedSize);
            }
        }
    }
}
