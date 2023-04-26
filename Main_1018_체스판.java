package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1018_체스판 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        char[][] sample = new char[8][8];


        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                sample[i][j] = i%2==j%2?'W':'B';
            }
        }

        char[][] board = new char[N][M];



        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
            }
        }


        //모든 탐색에서 두가지 반대의 경우 중 최솟값을 구한다는 로직은 똑같다.
        //잘 살리면 한번 했던 탐색은 다시 안 해도 될 것 같은데...

        int min = Integer.MAX_VALUE;
        int case1Cnt, case2Cnt;
        for (int i = 0; i <= N-8; i++) {
            for (int j = 0; j <= M-8; j++) {

                case1Cnt = 0;
                case2Cnt = 0;

                for (int r = 0; r < 8; r++) {
                    for (int c = 0; c < 8; c++) {
                        if(board[r+i][c+j] == sample[r][c]) case2Cnt++;
                        else case1Cnt++;
                    }
                }

                min = Math.min(min, Math.min(case1Cnt, case2Cnt));
            }
        }

        System.out.println(min);

    }
}