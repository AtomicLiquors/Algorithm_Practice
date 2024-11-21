package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_30458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        int[] cache = new int[200];

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for(int i = 0; i < N/2; i++){
            cache[input.charAt(i)]++;
            total++;
        }

        for(int i = (int)Math.ceil(N/2); i < N; i++){
            if(--cache[input.charAt(i)] < 0){
                System.out.println("No");
                return;
            }else{
                total--;
            }
        }

        System.out.println(total == 0 ? "Yes" : "No");
    }
}
