package page1.polymorphism;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int[] boxes = new int[100];

    static final int TEST_CASE = 10;
    static int dump;

    static int max = 0;
    static int min = 101;
    static int maxIdx;
    static int minIdx;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= TEST_CASE; tc++) {
            dump = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            flatten(0);
            //System.out.println(Arrays.toString(boxes));
            //System.out.println("#" + tc + " " + (max - min) + ", max & min : " + max + " " + min);


            int temp;
            max = 0;
            min = 101;
            for (int i = 0; i < 100; i++) {
                temp = boxes[i];

                if(temp > max) {
                    max = temp;
                    maxIdx = i;
                }
                if(temp < min) {
                    min = temp;
                    minIdx = i;
                }
            }

            System.out.println("#" + tc + " " + (max - min));
        }

        br.close();
    }



    static void flatten(int cnt) {

        while(cnt < dump) {
            int temp;
            max = 0;
            min = 101;

            for (int i = 0; i < 100; i++) {
                temp = boxes[i];

                if(temp > max) {
                    max = temp;
                    maxIdx = i;
                }
                if(temp < min) {
                    min = temp;
                    minIdx = i;
                }
            }//배열 전체를 돌면서 최대 최솟값을 찾는다.
            boxes[maxIdx]--;
            boxes[minIdx]++;
            cnt++;
        }
    }
}