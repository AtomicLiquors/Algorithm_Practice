package Codeforce.r835;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            if(N==1){
                System.out.println("YES"); continue;
            }
            long[] arr = new long[N];
            int cnt = 0;


            arr[0] = Integer.parseInt(st.nextToken());
            for (int i = 1; i < N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
                if(arr[i]==arr[i-1]) cnt++;
//                System.out.println(arr[i]);
//                System.out.println(arr[i-1]);
//                System.out.println(cnt);
            }
            if(cnt==N-1){
                System.out.println("NO"); continue;
            }

            int left = 0;
            int right = N-1;

            while(left < N-1)
                if(arr[left] < arr[++left]) break;


            while(right > 0)
                if(arr[right] < arr[--right]) break;


            System.out.println(left >= right? "YES": "NO");
        }

    }
}
