package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringBufferInputStream;
import java.util.*;

public class Main_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();
        Map<String, Integer> freqMap = new HashMap<>();

        while (N-- > 0) {
            String input = br.readLine();
            if(input.length() < M)
                continue;
            Integer frequency = freqMap.get(input);
            if(frequency == null){
                freqMap.put(input, 1);
                list.add(input);
            }else{
                freqMap.put(input, frequency+1);
            }
        }

        String[] arr = list.toArray(new String[0]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int freqGap = freqMap.get(o1) - freqMap.get(o2);
                if(freqGap != 0)
                    return -freqGap;
                int lengthGap = o1.length() - o2.length();
                if(lengthGap != 0)
                    return -lengthGap;
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String e : arr){
            sb.append(e).append('\n');
        }
        System.out.print(sb);
    }
}
