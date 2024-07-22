package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10989 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
           arr[i] = Integer.parseInt(br.readLine());

        quickSort(arr, 0, N-1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(arr[i]).append('\n');

        System.out.print(sb);
        br.close();
    }
    static void quickSort(int[] arr, int start, int end){
        if(start >= end)
            return;
        int pivot = end;

        int left = start;
        int right = end;

        while(left <= right){
            while(arr[pivot] > arr[left]){
                left++;
            }

            while(arr[pivot] < arr[right]){
                right--;
            }
            if(left <= right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
