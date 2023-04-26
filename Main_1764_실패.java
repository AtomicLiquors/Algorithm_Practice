import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Main_1764_실패 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        int N = nums.charAt(0)-'0';
        int M = nums.charAt(2)-'0';

        int result=0;

        List<String> nobodies = new LinkedList<>();
        //삭제가 빠른 리스트
        int lastIndex = 0;
        for (int i = 0; i < N; i++) {
            nobodies.add(br.readLine());
            lastIndex++;
        }

        PriorityQueue<String> strangers = new PriorityQueue();

        for (int i = 0; i < M; i++) {
            String stranger = br.readLine();
            for (int e = 0; e < lastIndex; e++) {
                if(nobodies.get(e).equals(stranger)){
                    nobodies.remove(e--);
                    strangers.offer(stranger);
                    result++;
                    lastIndex--;
                }
            }
        }

        System.out.println(result);
        while(!strangers.isEmpty()) {
            System.out.println(strangers.poll());
        }

    }
}
