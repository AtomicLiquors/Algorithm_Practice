import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1873_상호의배틀필드_최효빈 { //x값, y값 바꿔서 넣었다.

    static int H;
    static int W;

    static int currX;
    static int currY;

    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, -1, 0, 1};

    static int dir = 0;

    static char[][] map;

    static boolean isBlocked() {
        int nextX = currX + dX[dir];
        int nextY = currY + dY[dir];
        //System.out.println(nextX + ", " + nextY);
        //System.out.println(map[nextY][nextX]);
        if(nextX < 0 || nextY < 0 || nextX > W-1 || nextY > H-1)
            return true;
        else if(map[nextY][nextX] == '*' || map[nextY][nextX] == '#' || map[nextY][nextX] == '-')
            return true;
        else
            return false;
    }

    static void move() {
        currY += dY[dir];
        currX += dX[dir];
        //System.out.println("moved to " + currX +", " + currY);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            map = new char[H][W];

            for (int i = 0; i < H; i++) {
                String elements = br.readLine();
                for (int j = 0; j < W; j++) {
                    map[i][j] = elements.charAt(j);
                    if(map[i][j]=='<') {
                        dir = 0;
                        map[i][j] = '.';
                        currY = i;
                        currX = j;
                    }else if(map[i][j]=='^') {
                        dir = 1;
                        map[i][j] = '.';
                        currY = i;
                        currX = j;
                    }else if(map[i][j]=='>') {
                        dir = 2;
                        map[i][j] = '.';
                        currY = i;
                        currX = j;
                    }else if(map[i][j]=='v') {
                        dir = 3;
                        map[i][j] = '.';
                        currY = i;
                        currX = j;
                    }
                }
            }

            int N = Integer.parseInt(br.readLine());
            String cmds = br.readLine();

            for (int i = 0; i < cmds.length(); i++) {
                switch(cmds.charAt(i)) {
                    case 'S':
                        //전차 현재 위치를 시작으로, dir방향으로 한 칸씩 포탄을 보낸다.
                        //#를 만나면 그냥 break;
                        //*를 만나면 .로 바꿔버리고 break;
                        int ammoY = currY + dY[dir];
                        int ammoX = currX + dX[dir];

                        while(ammoY >= 0 && ammoX >= 0 && ammoY < H && ammoX < W ) {
                            //System.out.println("target : " + map[ammoY][ammoX]);
                            //System.out.println("location : " + ammoX + " " + ammoY);
                            if(map[ammoY][ammoX]=='#') {
                                break;
                            }else if(map[ammoY][ammoX]=='*') {
                                //System.out.println("recognized");
                                map[ammoY][ammoX] = '.';
                                break;
                            }
                            ammoY += dY[dir];
                            ammoX += dX[dir];
                        }

                        break;

                    //위치 변경 : dir을 조정.
                    //평지(.)가 있다면 평지와 전차 위치를 swap.
                    //또는 전차 현재 위치를 따로 저장해 두고 평지를 저장.
                    case 'U':
                        dir = 1;
                        if(!isBlocked()) move();
                        break;

                    case 'D':
                        dir = 3;
                        if(!isBlocked()) move();
                        break;

                    case 'L':
                        dir = 0;
                        if(!isBlocked()) move();
                        break;

                    case 'R':
                        dir = 2;
                        if(!isBlocked()) move();
                        break;
                }
                //System.out.println("direction : " + dX[dir] + " " + dY[dir]);
                //System.out.println(i + " : " + cmds.charAt(i));
/*
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < H; k++) {
                    for (int j = 0; j < W; j++) {
                        sb.append(map[k][j]);
                        //if map[i][j] == '<'
                    }
                    sb.append("\n");
                }
                System.out.println(sb);*/


            }


            switch (dir){
                case 0:
                    map[currY][currX] = '<';
                    break;
                case 1:
                    map[currY][currX] = '^';
                    break;
                case 2:
                    map[currY][currX] = '>';
                    break;
                case 3:
                    map[currY][currX] = 'v';
                    break;

            }



            StringBuilder sb = new StringBuilder();
            sb.append('#').append(tc).append(" ");

            //전차는 위치만 받고, 출력 시점에서 현재 dir상태 반영하기.

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }




        br.close();
    }
}