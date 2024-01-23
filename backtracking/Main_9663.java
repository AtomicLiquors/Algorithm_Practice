package backtracking;

import java.util.Scanner;

public class Main_9663 {
    //NQueen

    static int N;
    static int answer = 0;
    static int[] queensCol;
    static int currRow;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        queensCol = new int[N+1];

        for (int col = 0; col < N; col++) {
            placeQueen(col, 1);
        }

        System.out.println(answer);
    }

    static void placeQueen(int currCol, int cnt){
        if(cnt == N){
            answer++;
            return;
        }
        queensCol[cnt] = currCol;

        for (int col = 0; col < N; col++) {
            boolean queenCheck = false;
            int nextCnt = cnt+1;
            for (int row = 1; row <= cnt; row++) {
                if(col == queensCol[row] || (nextCnt - row) == Math.abs(col - queensCol[row])){
                    queenCheck = true;
                    break;
                }
            }
            if(queenCheck) continue;
            placeQueen(col, nextCnt);
        }
    }
}
