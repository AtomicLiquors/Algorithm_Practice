package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean notFound = true;

        int title = 666;
        int cnt = 0;
        while(notFound){
            if((title + "").contains("666") && ++cnt == N)
                break;
            title++;
        }

        System.out.println(title);

        // 최적화(100ms) : https://www.acmicpc.net/source/87172313
    }
}
