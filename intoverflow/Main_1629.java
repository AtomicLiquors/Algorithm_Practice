package intoverflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629 {

    static int A, B, C, modAC;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        modAC = A % C;

        System.out.println(recur(B) % C);
    }


    static int recur(int curr){
        if(curr == 1)
            return A;
        long modCurrC = recur(curr / 2) % C;
        long mult = (modCurrC * modCurrC) % C;
        return (int)(( mult * (curr % 2 == 0 ? 1 : modAC)) % C);
    }
}
