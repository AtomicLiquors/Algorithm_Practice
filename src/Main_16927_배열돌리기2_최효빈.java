import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16927_배열돌리기2_최효빈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //실패

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken()); //회전수
        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //맵 채우기
        int cnt = 0;
        int n = N;
        int m = M;
        while (N > 0 && M > 0){
            System.out.println("N : " + N);
            System.out.println("M : " + M);

            Queue<Integer> queue = new LinkedList<>();

            int x = cnt;
            int y = cnt;

            //큐에 넣기
            for (int i = 0; i < N-1; i++) {
                queue.offer(map[x][y]);
                x++;
                System.out.println(queue.poll());
            }

            for (int i = 0; i < M-1; i++) {

                queue.offer(map[x][y]);
                y++;
            }

            for (int i = 0; i < N-1; i++) {
                queue.offer(map[x][y]);
                x--;
            }

            for (int i = 0; i < N-1; i++) {
                queue.offer(map[x][y]);
                y--;
            }



            //회전수만큼 큐 돌리기
            for (int i = 0; i < R; i++) {
                queue.offer(queue.poll());
            }


            //도로 맵에 넣기
            x = cnt;
            y = cnt;

            for (int i = 0; i < N-1; i++) {
                map[x][y] = queue.poll();
                x++;
            }

            for (int i = 0; i < M-1; i++) {
                map[x][y] = queue.poll();
                y++;
            }

            for (int i = 0; i < N-1; i++) {
                map[x][y] = queue.poll();
                x--;
            }

            for (int i = 0; i < M-1; i++) {
                System.out.println("x: "+  x);
                System.out.println("y: "+y);
                map[x][y] = queue.poll();
                y--;
            }

            cnt++;
            N -= 2;
            M -= 2;
        }

        //출력
        //System.out.println(Arrays.deepToString(map));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        br.close();
    }
}
