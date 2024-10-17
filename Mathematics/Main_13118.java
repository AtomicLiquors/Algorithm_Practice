package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> people = new ArrayList<>();
        people.add(Integer.MIN_VALUE);

        while(st.hasMoreTokens()){
            people.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());

        int answer = 0;

        for(int idx = 1; idx < people.size(); idx++){
            if(people.get(idx) == x){
                answer = idx;
                break;
            }
        }

        System.out.println(answer);
    }
}
