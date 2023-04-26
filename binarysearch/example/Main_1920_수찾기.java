package binarysearch.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main_1920_수찾기 {
//	직접 구현시 1212ms, API이용시(Arrays.binarySearch) 620ms + 메모리 10000kb 절감
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(target, 0, N-1)?1:0);
        }
    }

    static boolean binarySearch(int target, int start, int end){
        if(start > end) return false;

        int mid = (start + end)/2;

        if(arr[mid] == target) return true;
        else if(arr[mid] > target) return binarySearch(target, start, mid-1);
        else return binarySearch(target, mid+1, end);
    }
}
