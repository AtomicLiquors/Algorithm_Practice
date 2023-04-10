import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main_Josephus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] victims = new int[N];
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        int rep = K-1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < rep; j++) {
                q.offer(q.poll());
            }
            victims[i] = q.poll();
        }

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 0; i < N; i++) {
            sb.append(victims[i]);
            if(i != N-1) sb.append(',').append(" ");
        }
        sb.append('>');

        System.out.println(sb);
    }
}
