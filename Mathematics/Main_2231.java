package Mathematics;

import java.util.Scanner;

public class Main_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int curr = i;
            int sum = i;
            while(curr > 0){
                sum += curr % 10;
                curr /= 10;
            }
            if(sum == N){
                answer = i;
                break;
            }

        }
        System.out.println(answer);
    }
}
