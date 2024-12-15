package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maxFrequency = 0;
        double sum = 0;
        int[] cache = new int[8001];
        for (int i = 0; i < N; i++) {
            sum += arr[i] = Integer.parseInt(br.readLine());

            int currIdx = convertValueToIndex(arr[i]);
            maxFrequency = Math.max(++cache[currIdx], maxFrequency);
        }
        Arrays.sort(arr);

        int result = 0;
        int cnt = 0;
        for(int i = -4000; i <= 4000; i++){
            int idx = convertValueToIndex(i);
            if(cache[idx] == maxFrequency){
                result = i;
                if(++cnt == 2) break;
            }
        }


        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(sum / N)).append('\n');
        sb.append(arr[N/2]).append('\n');
        sb.append(result).append('\n');
        sb.append(arr[N-1] - arr[0]).append('\n');

        System.out.print(sb);
        br.close();
    }

    static int convertValueToIndex(int value){
        return value < 0 ? 4000 - value : value;
    }

}
