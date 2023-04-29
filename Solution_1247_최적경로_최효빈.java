package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_최효빈 {

    static int N;
    static int min;


    static boolean[] isSelected;
    static int[] numbers;
    static int[][] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            min = Integer.MAX_VALUE;

            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[][] coords = new int[N+2][2];

            for (int i = 0; i < N+2; i++) {
                coords[i][0] = Integer.parseInt(st.nextToken());
                coords[i][1]  = Integer.parseInt(st.nextToken());
            }


            dists = new int[N+2][N+2];

            for (int i = 0; i < N+2; i++) {
                for (int j = i+1; j < N+2; j++) {
                    dists[i][j] = Math.abs(coords[i][0]-coords[j][0]) + Math.abs(coords[i][1]-coords[j][1]);
                    dists[j][i] = dists[i][j];
                }
            }

            isSelected = new boolean[N+2];
            numbers = new int[N];
            perm(0);



            System.out.printf("#%d %d\n", tc, min);
            //System.out.println(Arrays.deepToString(dists));
        }
    }


    static void perm(int cnt){
        if(cnt == N){
            //action
            //System.out.println(Arrays.toString(numbers));

            int from = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += dists[from][numbers[i]];
                //System.out.println( from + " to " + numbers[i] + " is " + dists[from][numbers[i]]);
                if(sum > min) return;
                from = numbers[i];
            }
            sum += dists[from][1];
            min = Math.min(sum, min);

            return;
        }

        for (int i = 2; i < N+2; i++) {
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            perm(cnt+1);
            isSelected[i] = false;
        }
    }
}
