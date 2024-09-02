package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10986 {
    public static void main(String[] args) throws IOException {
        // https://banwolcode.tistory.com/47

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] prefix = new int[N+1];
        int[] cache = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            prefix[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i] + prefix[i-1];
            cache[prefix[i] % M]++;
        }

        // 누적합 자체의 나머지가 0인 경우의 수
        int answer = cache[0];

        // 나머지가 일치하는 부분합들 중 2개를 고르는 경우의 수
        for (int value : cache) {
            answer += ((value * --value) / 2);
        }

        System.out.println(answer);
    }
}
