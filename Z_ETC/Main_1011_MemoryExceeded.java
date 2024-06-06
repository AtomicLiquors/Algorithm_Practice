package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 작성 시간 35분 30초, 메모리 초
// 왜 메모리 초과가 나는지 시간복잡도로 설명해 봐라. GPT한테 물어보든가
class Movement{
    int pos;
    int dist;
    int cnt;

    Movement(int pos, int dist, int cnt){
        this.pos = pos;
        this.dist = dist;
        this.cnt = cnt;
    }

}

public class Main_1011_MemoryExceeded {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Queue<Movement> que = new ArrayDeque<>();
            que.offer(new Movement(x+1, 1, 1));

            while(!que.isEmpty()){
                Movement curr = que.poll();
                int pos = curr.pos;
                int dist = curr.dist;
                int cnt = curr.cnt;

                if(pos == y && dist == 1){
                    sb.append(cnt).append('\n');
                    que.clear();
                    break;
                }

                for(int i = -1; i <= 1; i++){
                    int destination = pos + dist + i;
                    if(destination > pos && destination <= y)
                        que.offer(new Movement(destination, dist + i, cnt + 1));
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
