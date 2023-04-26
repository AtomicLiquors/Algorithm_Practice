package Codeforce.r827;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_A_Sum{
    public static void main(String[]args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            int sum = 0;
            int[] nums = new int[3];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
                sum += nums[i];
            }

            boolean flag = false;
            for (int i = 0; i < 3; i++) {
                if(sum == nums[i]*2){
                    flag = true;
                    break;
                }
            }

            System.out.println(flag?"YES":"NO");
        }
    }
}

