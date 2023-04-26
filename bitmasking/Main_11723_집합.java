package bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11723_집합 {
    public static void main(String[] args) throws IOException {
        int S = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());

        int n;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd){
                case "add":
                    n = Integer.parseInt(st.nextToken());
                    S |= (1<<n);
                    break;
                case "remove":
                    n = Integer.parseInt(st.nextToken());
                    S &= ((1<<n) - 1);
                    break;
                case "check":
                    n = Integer.parseInt(st.nextToken());
                    sb.append( (S & (1<<n))!=0?1:0 ).append("\n");
                    break;
                case "toggle":
                    n = Integer.parseInt(st.nextToken());
                    S ^= (1<<n);
                    break;
                case "all":
                    S = 2097151;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.println(sb);
    }
}
