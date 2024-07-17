package Codeforce.r943;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_A {

    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int criteria = 0;
            int curr = 0;
            int x = Integer.parseInt(br.readLine());
            for (int y = 1; y < x; y++) {
                int currCriteria = gcd(x, y) + y;
                if(currCriteria > criteria){
                    curr = y;
                    criteria = currCriteria;
                }
            }
            sb.append(curr).append('\n');
        }
        System.out.print(sb);
    }

    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        String key = a + "_" + b;
        if(map.get(key) == null){
            map.put(key, gcd(b, a % b));
        }
        return map.get(key);
    }
}
