package recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9095 {
    static int[] cache;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cache = new int[12];
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 2;
        cache[3] = 4;
        cache[4] = 7;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            int input = Integer.parseInt(br.readLine());
            sb.append(solve(input)).append('\n');
        }

        System.out.print(sb);
    }

    static int solve(int n){
        if(n <= 0)
            return 0;
        if(cache[n] > 0)
            return cache[n];

        int answer = 0;

        for (int i = 3; i >= 1; i--) {
            answer += solve(n-i);
        }

        return cache[n] = answer;
    }
}
