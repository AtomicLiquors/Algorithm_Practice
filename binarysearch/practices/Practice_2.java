package binarysearch.practices;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Practice_2 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{2, 3, 4, 4, 5, 6, 6, 6, 7, 8};

        int left = 0;
        int right = arr.length;

        int target = 6;

        while(left < right){
            int mid = (left + right) / 2;

            if(arr[mid] > target){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
