package Mathematics.GCD;

import java.io.IOException;
import java.util.Scanner;

public class Main_9924 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(gcd(A, B));
    }

    static int gcd(int A, int B){
        if(A == B)
            return 0;
        return gcd(Math.max(A, B) - Math.min(A, B), Math.min(A, B)) + 1;
    }
}
