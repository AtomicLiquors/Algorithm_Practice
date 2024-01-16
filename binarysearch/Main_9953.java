package binarysearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_9953 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;

        while(true){
            input = Integer.parseInt(br.readLine());
            if(input == 0) break;
            int answer = 1;
            int curr = 50;
            int start = 0;
            int end = 100;

            if(curr == input){
                System.out.println(answer);
                break;
            }
            if(input % 2 == 1) {
                curr = 49;
                answer++;
            }
            while(true){
                System.out.println(curr);
                if(curr == input) break;

                else if(curr < input){
                    start = curr;
                    curr = curr + (end - curr) / 2;
                }else{
                    end = curr;
                    curr = start + (curr - start) / 2;
                }
                answer++;
            }
            System.out.println(answer);
        }

        br.close();
    }


}
