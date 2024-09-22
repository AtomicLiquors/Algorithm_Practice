package combinatorics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_N과M8 {

    static int N;
    static int M;
    static int[] arr;
    static int[] numbers;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        numbers = new int[M];
        for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        perm(0, 0);
        bw.close();
        br.close();
    }

    static void printNumbers() throws IOException{
        StringBuilder sb = new StringBuilder();
        for(int number : numbers){
            sb.append(number).append(' ');
        }
        sb.append('\n');
        bw.write(sb.toString());
        bw.flush();
    }

    static void perm(int cnt, int start) throws IOException{
        if (cnt == M){
            printNumbers();
            return;
        }

        for (int i = start; i < N; i++) {
            numbers[cnt] = arr[i];
            perm(cnt+1, i);
        }
    }
}
