package Codeforce.r946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_C {
    public static void main(String[] args) throws IOException {
        // 오답 : test case 2번 탈락
        // https://github.com/AmitRoy3370/Codeforces/commit/e52667c4bf812e8ffb9112414ab3c7b9c4fc1e75
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            long beautifulCount = 0;

            int[][] prefix = new int[4][N];

            for(int i = 0; i < N; i++){
                int r = i % 4;
                for (int j = i+1; j < N; j++) {
                    if(arr[i] == arr[j])
                        prefix[r][j] = 1;
                    prefix[r][j] += prefix[(r+3) % 4][j-1];

                    if(i >= 2 && j >= 3){
                        int equalCount = prefix[r][j];
                        equalCount -= prefix[(r+1) % 4][j-3];
                        if(equalCount == 2)
                            beautifulCount++;
                    }
                }
            }

            sb.append(beautifulCount).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
