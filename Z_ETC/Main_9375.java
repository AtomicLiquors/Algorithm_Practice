package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int N;

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            int[] clothes = new int[31];
            int idx = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                //중복조회
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String target = st.nextToken();
                if(map.containsKey(target)){
                    clothes[map.get(target)]++;
                }else{
                    map.put(target, idx);
                    clothes[idx] = 2;
                    idx++;
                }
            }

            int result = 1;
            for (int i = 0; i <= 30; i++) {
                if(clothes[i]!=0)
                    result *= clothes[i];
            }
            System.out.println(result - 1);
        }
    }
}
