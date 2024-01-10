import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {

    static int N, falseCount, trueCount;

    static boolean[][] colors;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        colors = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                colors[i][j] = ( st.nextToken().equals("1"));
            }
        }

        falseCount = 0;
        trueCount = 0;

        square(N, 0,0,colors[0][0]);

        System.out.println(falseCount);
        System.out.println(trueCount);
    }

    static void square(int len, int startR, int startC, boolean color){

        int currR;
        boolean notSquare = false;
        for (int i = 0; i < len; i++) {
            currR = startR + i;
            for (int j = 0; j < len; j++) {
               if(colors[currR][startC + j] != color){
                   notSquare = true;
                   break;
               }
            }
        }

        if(notSquare){
            int half = len/2;
            int divR = startR + half;
            int divC = startC + half;

            square(half, startR, startC, colors[startR][startC]);
            square(half, divR, startC, colors[divR][startC]);
            square(half, startR, divC, colors[startR][divC]);
            square(half, divR, divC, colors[divR][divC]);
        }else{
            if(color)
                trueCount++;
            else
                falseCount++;
        }

    }
}
