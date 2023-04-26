package combinatorics;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationNext {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] input = new int[N];

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
        }

        //Arrays.sort(input);
        np(input);
        System.out.println(Arrays.toString(input));

        /*
        do{
            System.out.println(Arrays.toString(input));
        }while(np(input));
*/

        //np 1번만 쓰는 문제 복기해. -> 오름차순 정렬 없애고 np 한번만 실행

        /*===========*/
        /*
        Arrays.sort(input);

        do{
            System.out.println(Arrays.toString(input));
        }while(np(input));*/

    }

    static boolean np(int[] input){
        int n = input.length - 1;

        int i = n;
        while(i>0 && input[i-1] >= input[i]) i--;
        if(i==0) return false;

        int j = n;
        while(input[i-1] >= input[j]) j--;

        swap(input, i-1, j);

        int k = n;
        while(i < k){
            swap(input, i++, k--);
        }

        return true;
    }

    /*

    static boolean np(int[] input){

        int n = input.length;

        //뒤쪽부터 꼭대기 찾기
        int i = n - 1; //뒤쪽부터
        while(i>0 && input[i-1] >= input[i]) --i;
         //꼭대기 찾기
        if(i==0) return false; //꼭대기가 없다

        //꼭대기 직전 자리에 교환할 값 찾기
        int j = n - 1;
        while (input[i-1] >= input[j]) --j;

        //서로 교환
        swap(input, i-1, j);

        int k = n-1;
        while(i < k){
            swap(input, i++, k--);
        }

        return true;
    }

     */

    private static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }



}
