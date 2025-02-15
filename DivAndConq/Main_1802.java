package DivAndConq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main_1802 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(TC-- > 0) {
            String input = br.readLine();
            sb.append( test(input, 0, input.length()) ? "YES" : "NO" ).append('\n');
        }

        System.out.print(sb);
    }

    static boolean test(String input, int start, int end){
        // end is exclusive

        if(end - start <= 1)
            return true;

        int mid = (start + end) / 2;

        for (int i = start; i < mid; i++) {
            char left = input.charAt(i);
            char right = input.charAt(end - i - 1);

            if(left == right)
                return false;
        }
        return test(input, start, mid) && test(input, mid+1, end);
    }
}
