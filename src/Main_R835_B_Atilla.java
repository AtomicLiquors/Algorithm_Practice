import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_R835_B_Atilla {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String word = br.readLine();
            int max = 0;
            for (int j = 0; j < N; j++) {
                max = Math.max(word.charAt(j)-96, max);
            }
            System.out.println(max);
        }
    }
}
