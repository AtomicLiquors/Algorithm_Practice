package Codeforce.r827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main_C_Stripes {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            br.readLine();
            char[][] map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                String line = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

           //

            for (int i = 0; i < 8; i++) {
                if(map[i][0] != '.'){
                    char prev = map[i][0];
                    int cnt = 1;
                    for (int j = 1; j < 8; j++) {
                        //System.out.print(map[i][j]);

                        if(map[i][j] != prev) break;
                        cnt++;
                    }
                    if(cnt==8){
                        System.out.println(prev);
                        break;
                    }
                }

                //System.out.println();
            }

            for (int i = 0; i < 8; i++) {
                if(map[0][i] != '.'){
                    char prev = map[0][i];
                    int cnt = 1;
                    for (int j = 1; j < 8; j++) {
                        //System.out.print(map[j][i]);

                        if(map[j][i] != prev) break;
                        cnt++;
                    }
                    if(cnt==8){
                        System.out.println(prev);
                        break;
                    }
                }

                //System.out.println();
            }
        }
    }
}
