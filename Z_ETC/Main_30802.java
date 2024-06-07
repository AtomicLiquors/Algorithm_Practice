package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_30802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        tShirt(sizes, T);
        pen(N, P);
    }

    static void tShirt(int[] sizes, int T){
        int total = 0;
        for(int sizeCnt : sizes){
            total += sizeCnt / T;
            total += (sizeCnt % T > 0 ? 1 : 0);
        }
        System.out.println(total);
    }

    static void pen(int N, int P){
        System.out.printf("%d %d", N/P, N%P);
    }
}
