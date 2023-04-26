import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_10816_숫자카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());

        int target;
        for (int i = 0; i < N; i++) {
            target = Integer.parseInt(st.nextToken());
            if(map.containsKey(target)){
                map.put(target, map.get(target)+1);
            }else{
                map.put(target, 1);
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            target = Integer.parseInt(st.nextToken());
            if(map.containsKey(target)){
                sb.append(map.get(target));
            }else{
                sb.append(0);
            }
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
