package array.twoDimensional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16967 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int[][] B = new int[H+X][W+Y];

        for (int h = 0; h < H+X; h++) {
            st = new StringTokenizer(br.readLine());
            for (int w = 0; w < W+Y; w++) {
                B[h][w] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int h = 0; h < H; h++){
            for(int w = 0; w < W; w++){
                if(h >= X && w >= Y)
                    B[h][w] -= B[h-X][w-Y];
                sb.append(B[h][w]).append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
