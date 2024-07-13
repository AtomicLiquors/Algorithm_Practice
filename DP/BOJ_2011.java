import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011 {

    static int[] D;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String code = "0" + br.readLine();

        if(code.charAt(1) == '0'){
            System.out.println(0);
            return;
        }

        int N = code.length();

        D = new int[N];

        D[0] = 1;
        D[1] = 1;

        for (int i = 2; i < N; i++) {
            if(code.charAt(i) != '0') D[i] = D[i-1];
            char prev = code.charAt(i-1);

            if( prev == '1'){
                D[i] += D[i-2];
                D[i] %= 1000000; 
            }
               
            
            else if( prev == '2'){
                D[i] += (code.charAt(i) - '0' <= 6 ? D[i-2] : 0);
                D[i] %= 1000000;
            }
                
            else if ( code.charAt(i) == '0'){
                System.out.println(0);
                return;
            }
        }
        System.out.println(D[N-1]);
    }
}
