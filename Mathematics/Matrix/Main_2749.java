package Mathematics.Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2749 {

    static final long[][] first = {{1, 1},{1, 0}};
    static final long rem = 1_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        long[][] result = fibonacci(N-1);
        System.out.println(result[0][0]);
    }

    public static long[][] fibonacci(long N){
        if(N <= 1)
            return first;

        long[][] half = fibonacci(N/2);

        long[][] square = multiply(half, half);

        return N % 2 == 1 ? multiply(square, first) : square;
    }

    public static long[][] multiply(long[][] A, long[][] B){
        long topLeft = calc(A[0][0], B[0][0], A[0][1], B[1][0]);
        long topRight = calc(A[0][0], B[0][1], A[0][1], B[1][1]);
        long bottomLeft = calc(A[1][0], B[0][0], A[1][1], B[1][0]);
        long bottomRight = calc(A[1][0], B[0][1], A[1][1], B[1][1]);

        return new long[][] {
                {topLeft, topRight},
                {bottomLeft, bottomRight}
            };
    }

    public static long calc(long A, long B, long C, long D){
        return ((A * B) % rem + (C * D) % rem) % rem;
    }

}
