package binarysearch;

public class Practice_3 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4, 4, 4, 6, 7, 7, 9};

        int left = 0;
        int right = arr.length - 1;
        int target = 4;
        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] >= target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
}
