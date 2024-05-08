package DP;

public class Programmers_43105 {

        public int solution(int[][] triangle) {
            int answer = 0;
            int len = triangle.length;
            if(len == 1)
                return triangle[0][0];

            int[][] DP = new int[len][len];
            DP[0][0] = triangle[0][0];

            for(int i = 1; i < len; i++){
                for(int j = 0; j <= i; j++){
                    int left = j > 0 ? DP[i-1][j-1] : 0;
                    int right = DP[i-1][j];
                    DP[i][j] = triangle[i][j] + Math.max(left, right);

                    answer = Math.max(answer, DP[i][j]);
                }
            }
            return answer;
        }

}

/*
import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];
            for (int j = 1; j < i; j++)
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
        }

        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }
}
* */