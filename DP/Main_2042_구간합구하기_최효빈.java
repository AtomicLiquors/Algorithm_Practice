package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_구간합구하기_최효빈 {

    static int N, M, K;

    static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N+1];

        long curr;
        for (int i = 1; i <= N; i++) {
            curr = Long.parseLong(br.readLine());
            arr[i] = curr;
            update(i, curr);
            //System.out.println("arr:" + Arrays.toString(arr));
            //System.out.println("tree:" + Arrays.toString(tree));
        }

        long a, b, c;
        for (int i = 0; i < M+K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            c = Long.parseLong(st.nextToken());

            if(a==1){
                update((int) b, c - tree[(int) b]);
                arr[(int) b] = c;
            }else{
                System.out.println(intervalSum(b, c));
            }

        }

    }

    static int preSum(int i){
        int result = 0;
        while(i > 0){
            result += tree[i];
            i -= (i & -i);
        }
        return result;
    }

    static void update(int i, long diff){
        while(i <= N){
            tree[i] += diff;
            i += (i & -i);
        }
    }

    static int intervalSum(long from, long to){
        return preSum((int)to) - preSum((int)from-1);
    }
}
