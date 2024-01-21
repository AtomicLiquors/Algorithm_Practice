package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Meeting {

    int start;
    int end;

    Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Main_1931 {
    static boolean[] occupied;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<Meeting> eq = new PriorityQueue<>((o1, o2) -> {
            int endComparison = o1.end - o2.end;
            if (endComparison != 0) {
                return endComparison;
            } else {
                return o2.start - o1.start;
            }
        });

        int start, end;
        int currEnd = -1;

        int maxEnd = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            maxEnd = Math.max(end, maxEnd);
            eq.offer(new Meeting(start, end));
        }

        int left = 0;
        int right = 0;
        int answer = 0;

        while (!eq.isEmpty()){
            Meeting m = eq.poll();
            if(m.start == m.end){
                answer++;
                right = m.end;
            }else{
                if(m.end == right && m.start >= left){
                    answer++;
                    left = right = m.end;
                }else if(m.end > right && m.start >= right){
                    answer++;
                    left = right = m.end;
                }
            }
        }
        System.out.println(answer);
    }
}