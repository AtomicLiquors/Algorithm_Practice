package Mathematics.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_11444 {
    static final BigInteger TWO = new BigInteger("2");
    static final int REM = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        if(N.equals(BigInteger.ONE))
            System.out.println(1);
        else
            System.out.println(fibonacciMatrix(N.subtract(BigInteger.ONE))[0][0]);
    }

    static long[][] fibonacciMatrix(BigInteger N){
        if (N.equals(BigInteger.ONE))
            return new long[][]{{1, 1}, {1, 0}};

        long[][] half = fibonacciMatrix(N.divide(TWO));

        /*
        a, b
        c, d
         */
        long a = half[0][0];
        long b = half[0][1];
        long c = half[1][0];
        long d = half[1][1];

        long na = multiplyRowAndColum(a, b, a, c);
        long nb = multiplyRowAndColum(a, b, b, d);
        long nc = multiplyRowAndColum(c, d, a, c);
        long nd = multiplyRowAndColum(c, d, b, d);

        long[][] result = new long[][]{
            {na, nb},
            {nc, nd}
        };

        if(N.mod(TWO).equals(BigInteger.ONE)){
            result[0][0] = multiplyRowAndColum(na, nb, 1, 1);
            result[0][1] = multiplyRowAndColum(na, nb, 1, 0);
            result[1][0] = multiplyRowAndColum(nc, nd, 1, 1);
            result[1][1] = multiplyRowAndColum(nc, nd, 1, 0);
        }

        return result;
    }

    static long multiplyRowAndColum(long r1, long r2, long c1, long c2){
        return ((r1 % REM * c1 % REM) + (r2 % REM * c2 % REM)) % REM;
    }
}
