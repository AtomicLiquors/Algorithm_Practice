package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] abcCache = new int[91];
        int[] countCache = new int[10000001];
        int maxCount = 0;
        int maxAlphabet = 0;

        for (char ch : str.toCharArray()) {
            int curr = ch;
            if(curr > 90)
                curr -= 32;
            abcCache[curr]++;

            if(++countCache[abcCache[curr]] == 1){
                maxCount = abcCache[curr];
                maxAlphabet = curr;
            }
        }

        System.out.println(countCache[maxCount] == 1?
                (char)maxAlphabet
                : '?');
    }
}
