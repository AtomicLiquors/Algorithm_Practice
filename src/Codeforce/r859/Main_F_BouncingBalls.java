package Codeforce.r859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_F_BouncingBalls {
    //Main_F_BouncingBalls
    //실패
    //기저조건?
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dC = {1, -1, -1, 1};
        int[] dR = {1, 1, -1, -1};
        //DR = 0; DL = 1; UL = 2; UR = 3;

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int fR = Integer.parseInt(st.nextToken());
            int fC = Integer.parseInt(st.nextToken());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());
            String cmd = st.nextToken();

            int dir = 0;
            switch (cmd){
                case "DR":
                    dir = 0;
                    break;
                case "DL":
                    dir = 1;
                    break;
                case "UL":
                    dir = 2;
                    break;
                case "UR":
                    dir = 3;
                    break;
            }

            int nR, nC;
            int bounces = 0;
            int bounce = 0;
            int sR = fR;
            int sC = fC;
            while (true){
                nR = sR + dR[dir];
                nC = sC + dC[dir];

                while(nR < 1 || nR > R || nC < 1 || nC > C)//장외
                {
                    dir = (dir + 1)%4;
                    bounce = 1;
                    nR = sR + dR[dir];
                    nC = sC + dC[dir];
                }
                bounces += bounce;
                bounce = 0;
                sR = nR;
                sC = nC;

                //System.out.println(bounces);

                if(sR==fR && sC==fC){
                    System.out.println(-1);
                    break;
                }
                if(sR==eR && sC==eC){
                    System.out.println(bounces);
                    break;
                }
            }


        }

    }
}
