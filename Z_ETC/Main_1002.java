package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main_1002 {

    public static void main(String[] args) throws IOException{
        //두 원이 접하는지, 겹치는지, 겹치지 않는지, 일치하는지 구하는 문제. how?

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 0 0 2 0 1 2
            // 가 0으로 나오는 이유?

            // 반지름은 무조건 1보다 크다.

            //서로 같은 두 좌표
            if(x1 == x2 && y1 == y2){
                if(r1 == r2){
                    System.out.println(-1);
                }else{
                    System.out.println(0);
                }
                continue;
            }else if(r1 == 0 && r2 == 0){
                System.out.println(0);
                continue;
            }

            // 서로 다른 두 좌표
            int dist = (int)Math.pow(x1 - x2, 2) + (int)Math.pow(y1 - y2, 2);
            int rSum = (int)Math.pow(r1 + r2, 2);
            int smallR = (int)Math.pow(Math.min(r1, r2),2);
            int largeR = (int)Math.pow(Math.max(r1, r2),2);

            //둘 다 원일 때
            //결과값 1인 경우
            //직선 거리 = 반지름의 합 //직선 거리 = 작은 놈 반지름
            if(dist == rSum || dist == smallR && smallR > 0 ) System.out.println(1);
            else if(dist > rSum ||  dist < smallR) System.out.println(0);
            else System.out.println(2);
            //0인 경우
            //직선 거리 > 반지름의 합
            //또는
            //작은 놈 반지름 > 직선 거리 차


        }
    }
}
