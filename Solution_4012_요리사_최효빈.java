import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4012_요리사_최효빈 {
    //실패 - 개별 TC를 넣었을 때, 전체 TC를 넣었을 때 결과가 서로 다름
    static int N;
    static int numbers[];
    static boolean isSelected[];
    static int[][] map;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            numbers = new int[N/2];
            isSelected = new boolean[N+1];

            map = new int[N+1][N+1];
            for (int i = 1; i < N+1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < N+1; j++) {
                    int a, b;
                    if(i<j){ a = i; b = j;}
                    else{ a = j; b = i;}
                    map[a][b] += Integer.parseInt(st.nextToken());
                }
            }

            //System.out.println(Arrays.deepToString(map));


            comb(0, 1);


            System.out.println("#" + t + " " + min);
        }
    }


    static void comb(int cnt, int start){
        if(cnt==N/2){
            //System.out.println(Arrays.toString(numbers));
            //System.out.println(Arrays.toString(isSelected));
            check();
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers[cnt] = i;
            isSelected[i] = true;
            comb(cnt+1, i+1);
            isSelected[i] = false;
        }
    }

    static void check() {
        //https://javaju.tistory.com/25
        int A=0, B=0, result=0;

        for(int i = 1; i<N; i++) {
            for(int j = i+1; j<N+1; j++) {
                if(isSelected[i] && isSelected[j]) {
                    A += map[i][j];
                    //System.out.println("A : " + A);
                }
                else if(!isSelected[i] && !isSelected[j]) {
                    B += map[i][j];
                    //System.out.println("B : " + B);
                }
            }
        }
        result = Math.abs(A-B);
        min = Math.min(result, min);
    }
}
