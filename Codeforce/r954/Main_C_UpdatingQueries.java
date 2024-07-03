package Codeforce.r954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_C_UpdatingQueries {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            char[] str = new char[N+1];
            boolean[] shouldUpdate = new boolean[N+1];
            char[] updates = new char[M+1];

            String input = br.readLine();
            for (int i = 1; i <= N; i++) {
                str[i] = input.charAt(i-1);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                shouldUpdate[Integer.parseInt(st.nextToken())] = true;
            }

            input = br.readLine();
            for (int i = 1; i <= M; i++) {
                updates[i] = input.charAt(i-1);
            }
            Arrays.sort(updates);

            StringBuilder sb = new StringBuilder();
            int updatePt = 1;
            for (int i = 1; i <= N; i++) {
                if(shouldUpdate[i]){
                    sb.append(updates[updatePt++]);
                }else{
                    sb.append(str[i]);
                }
            }
            System.out.println(sb);
        }

        br.close();
    }
}
