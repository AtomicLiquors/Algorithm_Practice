package Z_ETC;

import java.io.*;

public class Solution_1954_ {
    static int N;
    static int M;

    static int n;
    static int value;
    static byte director;

    static int I; //현재 인덱스를 누군가 저장해야 한다.
    static int J;
    static int[][] map;
    //달팽이 숫자를 입력할 이차원 배열.

    public static void main(String[] args) throws IOException{
        //달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
        //다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)
        //가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
        int T = Integer.parseInt(br.readLine());


        for (int t = 1; t <= T; t++) {
            //각 테스트 케이스에는 N이 주어진다.
            N = Integer.parseInt(br.readLine()); //배열이 완성되고, 출력할 때 쓸 고정된 N값
            I = 0;
            J = 0; //초기화
            n = N; //유동적인 N값
            director = 0;
            map = new int[N][N];

            //map에 값 넣기
            //1차) N회만큼 첫 가로줄 채우기
            value = 1;
            map[I][J] = value;
            for (int k = 0; k < n-1; k++) {
                J++;
                map[I][J] = ++value;
            }
            //move(n-1,director);
            director += 64;


            //2차) 회차마다(N-1)회만큼 이동. 1번 반복마다 byte + 64;, 2번 반복마다 N--;
            while(n > 0) {
                n--;

                move(n, director);
                director += 64;

                move(n, director);
                director += 64;

            }


            //결과 출력
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }


    }

    static void move(int n, byte direction) {
        switch(direction) {
            case 64:
//                System.out.println("아래");

                for (int k = 0; k < n; k++) {
                    I++;
                    map[I][J] = ++value;
                }


                break;
            case -128:
//                System.out.println("오른쪽");
                for (int k = 0; k < n; k++) {
                    J--;
                    map[I][J] = ++value;
                }
                break;
            case -64:
//			System.out.println("위");
                for (int k = 0; k < n; k++) {
                    I--;
                    map[I][J] = ++value;
                }
                break;
            case 0:
                //	System.out.println("왼쪽");
                for (int k = 0; k < n; k++) {
                    J++;
                    map[I][J] = ++value;
                }
                break;
        }

    }

}