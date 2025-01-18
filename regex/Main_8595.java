package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8595 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String word = br.readLine();

        long answer = 0;

        String[] numbers = word.split("[A-z]+");
        for(String number : numbers){
            if(number.equals("") || number.length() > 6)
                continue;
            answer += Integer.parseInt(number);
        }

        System.out.println(answer);
    }
}
