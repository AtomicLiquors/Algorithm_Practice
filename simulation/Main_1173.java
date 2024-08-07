package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1173 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int X = m;

        int answer = 0;
        int totalWorkout = 0;
        if (m + T > M){
            // 불가능한 경우 : 초기 맥박에서 증가량을 더한 값이 항상 최대 맥박을 초과하여, 절대 운동을 할 수 없을 때
            System.out.println(-1);
            br.close();
            return;
        }

        while(totalWorkout < N){
            answer++;
            if(X + T <= M){
                X = workout(X, T);
                totalWorkout++;
            }else{
                X = rest(X, R, m);
            }
        }

        System.out.println(answer);
        br.close();
    }

    static int workout(int X, int T){
        return X + T;
    }

    static int rest(int X, int R, int m){
        return Math.max(X-R, m);
    }
}
