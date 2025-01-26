package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class HSAT_6283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[8];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());

        int diff = arr[1] - arr[0];
        boolean mixed = false;

        for (int i = 2; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if( (arr[i] - arr[i-1]) * diff < 0){
                mixed = true;
                break;
            }
        }
        System.out.println( mixed ? "mixed" : ( diff > 0 ? "ascending" : "descending") );
        br.close();
    }
}
