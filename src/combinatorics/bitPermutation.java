package combinatorics;

import java.util.Arrays;
import java.util.Scanner;

public class bitPermutation {

    static int input[];
    static int numbers[];
    static int N, R;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();

        numbers = new int[R];
        System.out.println(Arrays.toString(numbers));
        input = new int[N];
        System.out.println(Arrays.toString(input));

        System.out.println(N);
        System.out.println(R);

        for (int i = 0; i < N; i++) {
            input[i] = sc.nextInt();
            //중복된 원소가 있는 경우는?
        }

        perm(0,0);

    }

    static void perm(int cnt, int flag){
        if(cnt==R){
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 0; i < N; i++) {
            if( (flag & (1<<i)) != 0 ) continue;
            numbers[cnt] = input[i];

            perm(cnt+1, (flag | (1<<i)));
        }



/*
        if(cnt==R){
            System.out.println(Arrays.toString(numbers));
        }else{
            for (int i = 0; i < N; i++) {
                if( (flag & (1<<i)) != 0) continue;
                numbers[cnt] = input[i];
                perm(cnt+1, flag | (1<<i));
            }
        }
*/
    }
}
