package Codeforce.r859;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B_GrabCandles {
    //항상 짝수부터 맨 앞에 몰아주고, 홀수는 그 뒤부터 늘어놓는 방법을 생각할 수 있다.
    //결국은 짝수 합과 홀수 합을 비교하는 문제다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < A; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int evenSum = 0;
            int oddSum = 0;

            for (int j = 0; j < N; j++) {
                int curr = Integer.parseInt(st.nextToken());
                if(curr%2==0) evenSum += curr;
                else oddSum += curr;
            }
            if(evenSum > oddSum) System.out.println("YES");
            else System.out.println("NO");
        }
    }

}
