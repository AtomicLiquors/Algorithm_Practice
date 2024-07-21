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

        quickSort(arr, 0, N-2, N-1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++)
            sb.append(arr[i]).append('\n');

        System.out.print(sb);
        br.close();
    }
    static void quickSort(int[] arr, int left, int right, int idx){
        if(left >= right)
            return;
        int pivot = arr[idx];

        while(true){
            while(pivot > arr[left] || left < right){
                left++;
            }

            while(pivot < arr[right] || left < right){
                right--;
            }
            if(left < right)
                break;

            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
        }
        arr[idx] = arr[left];
        arr[left] = pivot;
        quickSort(arr, left, right-1, right);
        quickSort(arr, right+1, N-2, N-1);
    }
}
