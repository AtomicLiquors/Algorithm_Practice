package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.PriorityQueue;

public class Main_2870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        while(N-- > 0){
            String str = br.readLine();
            String[] arr = str.split("[a-z]+");

            for(String token : arr){
                if(token.equals(""))
                    continue;
                pq.offer(new BigInteger(token));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append('\n');
        }
        System.out.print(sb);
        br.close();
    }
}
