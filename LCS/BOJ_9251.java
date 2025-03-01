package LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String vertical = ' ' + br.readLine();
        String horizontal = ' ' + br.readLine();

        int[][] DP = new int[vertical.length()][horizontal.length()];

        for (int row = 1; row < vertical.length(); row++) {
            for (int col = 1; col < horizontal.length(); col++) {
                int curr = DP[row-1][col-1];
                if(vertical.charAt(row) == horizontal.charAt(col))
                    curr++;
                DP[row][col] = Math.max(DP[row-1][col], DP[row][col-1]);
                DP[row][col] = Math.max(curr, DP[row][col]);
            }
        }

        System.out.println(DP[vertical.length() - 1][horizontal.length() - 1]);
    }
}
