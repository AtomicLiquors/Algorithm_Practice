// 가장 긴 증가하는 부분 수열 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N==1){
            System.out.println(1);
            return;
        }


        int[] arr = new int[N];
        int[] LIS = new int[N];
        int answer = 0;

        Arrays.fill(LIS, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }



        for (int i = N-2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j < N; j++) {
               if(min < arr[j]) continue;

               if(arr[j] > arr[i]) {
                   LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                   min = Math.min(arr[j], min);
               }

            }
            answer = Math.max(LIS[i], answer);
        }

        System.out.println(answer);
    }
}
