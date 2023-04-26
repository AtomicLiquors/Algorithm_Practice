package Codeforce.r827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_Increasing {
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            int curr;
            boolean flag = true;
            for (int i = 0; i < N; i++) {
                curr = Integer.parseInt(st.nextToken());
                for (int j = 0; j < i; j++) {
                    if(arr[j] == curr){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
                arr[i] = curr;
            }

            System.out.println(flag?"YES":"NO");
        }
    }
}
