package Codeforce.r946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int maxPixels = 15;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int screens = y / 2;
            List<Integer> screenList = new ArrayList<>();

            for (int i = 0; i < screens; i++) {
                screenList.add(maxPixels - 4 * 2);
            }

            if(y % 2 == 1){
                screens++;
                screenList.add(maxPixels - 4);
            }

            int idx = 0;
            while(idx < screens && x > 0){
                int pixels = screenList.get(idx);
                if(x > pixels){
                    x -= pixels;
                    idx++;
                }else{
                    x = 0;
                }
            }

            screens += (x / 15) + (x % 15 > 0 ? 1 : 0);
            sb.append(screens).append("\n");

        }
        System.out.print(sb);
    }
}
