package Mathematics.BigInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String line = br.readLine();
        BigInteger hash = BigInteger.valueOf(0);
        for(int i = 0; i < L; i++){
            BigInteger code = BigInteger.valueOf(line.charAt(i) - 96);
            BigInteger mult = multiply(BigInteger.valueOf(31), i);
            hash = hash.add(code.multiply(mult));
        }
        System.out.println(hash.remainder(BigInteger.valueOf(1234567891)));
    }

    static BigInteger multiply(BigInteger down, int pow){
        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= pow; i++) {
            result = result.multiply(down);
        }
        return result;
    }
}
