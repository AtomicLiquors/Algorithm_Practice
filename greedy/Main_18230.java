package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_18230 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long beauty = 0;

        int N = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        Integer[] rect = new Integer[A];
        Integer[] square = new Integer[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            rect[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(rect, Collections.reverseOrder());

        int rectPt = 1;
        int squarePt = 0;

        if(N % 2 == 1){
            beauty += rect[0];
            rectPt++;
            N--;
        }


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            square[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(square, Collections.reverseOrder());

        while(N > 0){
            int maxSquare = squarePt < B ? square[squarePt] : 0;
            int maxRect = rectPt < A ? rect[rectPt-1] + rect[rectPt] : 0;

            if(maxSquare >= maxRect){
                beauty += maxSquare;
                squarePt++;
            }else{
                beauty += maxRect;
                rectPt+=2;
            }

            N -= 2;
        }

        System.out.println(beauty);
    }
}
