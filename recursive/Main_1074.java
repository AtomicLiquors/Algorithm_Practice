package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
    static int N, R, C, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

       answer = 0;

       int L = (int)Math.pow(2, N-1);
       Z(L, 0, L, L);
       System.out.println(answer);
    }

    static void Z(int L, int start, int r, int c) {
        if(L == 0){
            answer = start;
            return;
        }
        boolean rowPos = r > R;
        boolean colPos = c > C;

        int NL = L/2;
        if(rowPos){
           if(colPos){
               Z(NL, start, r - NL, c - NL);
           }else{
               Z(NL, start + L*L, r - NL, c + NL);
           }
        }else{
           if(colPos){
               Z(NL, start + L*L*2, r + NL, c - NL);
           }else
               Z(NL, start + L*L*3, r + NL, c + NL); {
           }
        }
    }
}
