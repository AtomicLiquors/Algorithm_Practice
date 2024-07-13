import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cache[] = new int[42];
        int answer = 0;

        for (int i = 0; i < 10; i++){
            int curr = Integer.parseInt(br.readLine());
            if(++cache[curr % 42] == 1) answer++;
        }

        System.out.println(answer);
    }
}
