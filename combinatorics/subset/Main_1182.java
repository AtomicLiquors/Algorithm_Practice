package combinatorics.subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1182 {

    static boolean[] isSelected;
    static int N, S, answer, array[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        answer = 0;
        array = new int[N];
        isSelected = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);

        System.out.println(answer);
    }

    static void subset(int idx){
        if(idx == N){
            int sum = 0;
            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if(isSelected[i]){
                    sum += array[i];
                    flag = true;
                }
            }
            if(sum == S && flag) answer++;
            return;
        }

        isSelected[idx] = true;
        subset(idx+1);
        isSelected[idx] = false;
        subset(idx+1);
    }
}
