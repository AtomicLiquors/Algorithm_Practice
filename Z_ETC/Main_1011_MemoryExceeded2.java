package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1011_MemoryExceeded2 {
    static int distance, DP[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            distance = y-x;
            DP = new int[distance+1];
            move(1, 1, 1);

            sb.append(DP[distance]).append('\n');
        }

        System.out.print(sb);
        br.close();
    }

    static void move(int position, int prevMovement, int moveCnt){
        DP[position] = moveCnt;
        int nextPosition, movement;
        for (int i = -1; i <= 1; i++) {
            movement = prevMovement + i;
            nextPosition = position + movement;

            if(nextPosition <= position || nextPosition > distance)
                continue;

            if(DP[nextPosition] != 0 && DP[nextPosition] <= moveCnt + 1)
                continue;

            if(nextPosition == distance && movement != 1)
                continue;


            move(nextPosition, movement, moveCnt+1);
        }
    }
}
