package array;

import javafx.scene.input.InputMethodTextRun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prev = 1;

        StringBuilder sb = new StringBuilder();
        sb.append(0).append(' ');

        for (int i = 2; i <= N; i++) {
           if(arr[prev] < arr[i]){
               prev = i;
               sb.append(0).append(' ');
           }else{
               sb.append(prev).append(' ');
           }
        }

        System.out.println(sb);
    }
}
