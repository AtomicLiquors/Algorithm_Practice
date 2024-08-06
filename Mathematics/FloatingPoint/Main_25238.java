package Mathematics.FloatingPoint;

import java.util.Scanner;

public class Main_25238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int defense = sc.nextInt();
        int pierce = sc.nextInt();

        System.out.println( defense * (100 - pierce) >= 10000 ? 0 : 1);
    }
}
