package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT_7628 {

    static int N, heaters[], answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        heaters = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            heaters[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, heaters[i]);
        }

        for (int i = 2; i <= max; i++) {
            int cnt = 0;
            for (int heater : heaters) {
                if(heater % i == 0)
                    cnt++;
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);
    }
}
