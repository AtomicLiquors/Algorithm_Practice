package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main_RGB거리 {
    //실패
    //min 활용한 점화식을 세울 수 있는가? 있다면 정답으로 쳐주겠다.
    //반복문으로 한번, 재귀함수로 한번.

    static int N, map[][], D[][];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[3][N];
        D = new int[3][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[0][i] = Integer.parseInt(st.nextToken());
            map[1][i] = Integer.parseInt(st.nextToken());
            map[2][i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0, 0);
        System.out.println(min);
    }

    static void dfs(int sum, int flag, int cnt){
        if(sum >= min){
            return;
        }else if(cnt==N){
            min = Math.min(sum, min);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if( (flag & (1<<i)) != 0 ){
                continue;
            }


            dfs(sum + map[i][cnt], 1<<i, cnt+1);
        }

    }
}
