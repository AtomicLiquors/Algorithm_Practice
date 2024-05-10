package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_리모컨 {
    public static void main(String[] args) throws IOException {

        System.out.println((int)Math.log10(3000));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = 100;
        String Nstr = br.readLine();
        int cnt = 0;

        int N = Integer.parseInt(Nstr);
        if(N==100){
            System.out.println(0);
            return;
        }

        int M = Integer.parseInt(br.readLine());
        if(M==0){
            System.out.println(Nstr.length());
            return;
        }else if (M==10){
            cnt += Nstr.length() + Math.abs(N-A);
            System.out.println(cnt);
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] buttons = new boolean[10];



        for (int i = 0; i < M; i++) {
            buttons[Integer.parseInt(st.nextToken())] = false;
        }


    }
}
