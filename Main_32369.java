import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_32369 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int cheered = 1;
        int blamed = 1;
        for (int i = 0; i < N; i++) {
            cheered += A;
            blamed += B;

            if(cheered == blamed)
                blamed--;
            else if(cheered < blamed){
                int temp = blamed;
                blamed = cheered;
                cheered = temp;
            }
        }

        System.out.printf("%d %d", cheered, blamed);
    }
}
