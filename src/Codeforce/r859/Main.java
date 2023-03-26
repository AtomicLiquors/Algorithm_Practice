package Codeforce.r859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] alphabet;
        for (int i = 0; i < T; i++) {
            alphabet = new int[26];
            int N = Integer.parseInt(br.readLine());
            boolean pass = true;
            String line = br.readLine();
            //-97
            int curr;
            for (int j = 0; j < N; j++) {
                curr = line.charAt(j)-97;
                if(alphabet[curr] != 0){
                    //System.out.println(j+1 - alphabet[curr]);
                    if( (j+1 - alphabet[curr]) % 2 == 1){
                        pass = false;
                        break;
                    }
                }else alphabet[curr] = j+1;
            }

            if(pass) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
