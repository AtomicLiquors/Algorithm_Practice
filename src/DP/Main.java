package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
/*


    A와 B의 핸드폰 번호에서 맨 앞의 010과 "-"(하이픈)을 모두 제외한 후,
    A부터 시작하여 한 숫자씩 번갈아가면서 적는다.
    그리고 인접한 두 숫자끼리 더한 값의 일의 자리를 두 숫자의 아래에 적어나가면서 마지막에 남는 숫자 2개로 궁합률을 구하게 된다.

    예를 들어, 아래의 그림과 같이
    A의 번호가 010-7475-9336 이고,
    B의 번호가 010-3619-5974 이면,
    7346715995393764에서 시작하여
    070386484822030,
    77314022204233,
    4045424424656,
    449966866011,
    83852442612,
    1137686873,
    240344450,
    64378895,
    0705674,
    775131,
    42644, 6808, 488, 26이 되어 둘은 26%의 궁합률을 가지게 된다.

    십의 자리가 0이어도 앞에 0을 붙여 두자리로 출력한다.*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();

        int a = A.charAt(0)-'0';
        int b = B.charAt(0)-'0';

        for (int i = 1; i < 8; i++) {
            a += b;
            b += A.charAt(i)-'0';
            System.out.println(a);
            System.out.println(b);
            a += b;
            b += B.charAt(i)-'0';
            System.out.println(a);
            System.out.println(b);
        }


        System.out.print(a%10);
        System.out.print(b%10);
    }
}
