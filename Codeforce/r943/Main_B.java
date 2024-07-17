package Codeforce.r943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            String A = br.readLine();
            String B = br.readLine();


            int left = 0;
            int right = 0;
            int k = 0;
            while(left < N && right < M){
                if(A.charAt(left) == B.charAt(right)){
                    k++;
                    left++;
                }
                right++;
            }

            sb.append(k).append('\n');
        }
        System.out.print(sb);
        br.close();

    }
}
