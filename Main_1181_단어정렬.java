package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main_1181_단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<String>[] arr = new PriorityQueue[51];
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i <= 50; i++) {
            arr[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if(set.contains(str)) continue;
            arr[str.length()].offer(str);
            set.add(str);
        }

        StringBuilder sb;
        for (int i = 1; i <= 50; i++) {
            sb = new StringBuilder();
            while (!arr[i].isEmpty()){
                sb.append(arr[i].poll()).append("\n");
            }
            System.out.print(sb);
        }
    }
}
