package binarysearch.practices;

public class Practice_4 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 4, 4, 4, 6, 7, 7, 9};

        System.out.println(upperBound(arr, 4));
        System.out.println(lowerBound(arr, 4));
        System.out.println(upperBound(arr, 7));
    }

    public static int upperBound(int[] arr, int key){
        int top = arr.length;
        int bottom = 0;

        while(top > bottom){
            int mid = bottom + (top - bottom) / 2;

            if(arr[mid] > key)
                top = mid;
            else
                bottom = mid + 1;
        }

        return bottom - 1;
    }

    public static int lowerBound(int[] arr, int key){
        int top = arr.length;
        int bottom = 0;

        while(top > bottom){
            int mid = bottom + (top - bottom) / 2;

            if(arr[mid] >= key)
                top = mid;
            else
                bottom = mid + 1;
        }

        return bottom;
    }
}
