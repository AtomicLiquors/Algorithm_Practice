package binarysearch;

import java.util.Arrays;

public class Practice {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 3, 3, 4, 4};

        int left = 0;
        int right = arr.length;

        int mid = -1;
        int crit = 4;

        while(left < right){
            mid = (left + right) / 2;
            if(arr[mid] >= crit){
                right = mid;
            }else{
                left = mid+1;
            }
        }

        System.out.println(left);
        System.out.println(Arrays.binarySearch(arr, crit));
    }
}
