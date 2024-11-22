package combinatorics.combination.examples;

import java.util.Arrays;

public class CombinationStandard {

    static int N = 4;
    static int R = 3;

    static int input[] = new int[N];
    static int numbers[] = new int [R];

    public static void main(String[] args) {
        comb(0, 1);
    }

    static void comb(int cnt, int start){
        if(cnt == R){
            System.out.println(Arrays.toString(numbers));
        }else{
            for (int i = start; i <= N; i++) {
                numbers[cnt] = i;
                comb(cnt+1, i+1);
            }
        }
    }
}
