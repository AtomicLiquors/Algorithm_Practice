package Codeforce.r954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_XAxis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int answer = 0;
            int[] arr = new int[3];
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            for(int i = 0; i < 3; i++){
                for (int j = i+1; j < 3; j++) {
                    answer = Math.max(answer, Math.abs(arr[i]-arr[j]));
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb);
        br.close();
    }
}
