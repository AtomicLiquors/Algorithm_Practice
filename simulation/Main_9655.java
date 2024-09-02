package simulation;

import java.util.Scanner;

public class Main_9655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // n이 1 또는 3일 때 항상 상근이가 이긴다.
        // 정수 a에 대해 n이 1 + 2a 또는 3 + 2a일 때 항상 상근이가 이긴다.
        // 상근이가 먼저 1 또는 3을 가져가면 2a를 창영이가 남김없이 가져갈 방법이 없다.
        System.out.println( N % 2 == 1 ? "SK" : "CY");
    }
}
