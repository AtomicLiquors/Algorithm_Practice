package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer studentTokens = new StringTokenizer(br.readLine());
        StringTokenizer directorTokens = new StringTokenizer(br.readLine());

        int B = Integer.parseInt(directorTokens.nextToken());
        int C = Integer.parseInt(directorTokens.nextToken());

        long answer = N;
        for (int i = 0; i < N; i++) {
            int students = Integer.parseInt(studentTokens.nextToken());
            int remainingStudents = Math.max(0, students - B);
            answer += (remainingStudents / C) + (remainingStudents % C > 0 ? 1: 0);
        }

        System.out.println(answer);
    }
}
