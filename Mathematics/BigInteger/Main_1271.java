package Mathematics.BigInteger;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1271 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        BigInteger N = new BigInteger(st.nextToken());
        BigInteger M = new BigInteger(st.nextToken());

        System.out.println(N.divide(M));
        System.out.print(N.remainder(M));
    }
}
