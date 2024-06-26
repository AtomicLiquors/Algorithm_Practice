package Z_ETC;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

public class Main_2448 {

    static Deque<Integer> que = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        que.offer(N);

        boolean[] mark = new boolean[6145];
        int start = N;
        int end = N;
        for (int i = 0; i < N/3; i++) {
            for (int j = 1; j <= end; j++) {
                if(j == que.peekFirst()){
                    sb.append('*');
                    que.poll();
                    que.offer(j - 1);
                }else{
                    sb.append(' ');
                }
            }

            sb.append('\n');
            start--;
            end++;

            for (int j = 1; j <= end; j++) {
                if(j == que.peekFirst()){
                    sb.append("* *");
                    que.poll();
                    que.offer(j - 1);
                    j += 2;
                }else{
                    sb.append(' ');
                }
            }

            sb.append('\n');
            start--;
            end++;

            for (int j = 1; j <= end; j++) {
                if(j == que.peekFirst()){
                    if(i % 2 == 0 || j == start)
                        que.offer(j-1);
                    if(j != N)
                    sb.append("*****");
                    que.poll();
                    j += 4;
                    if(i % 2 == 0 || j == end)
                        que.offer(j+1);
                }else{
                    sb.append(' ');
                }
            }

            sb.append('\n');
            start--;
            end++;

        }
        System.out.println(sb);
    }


}
