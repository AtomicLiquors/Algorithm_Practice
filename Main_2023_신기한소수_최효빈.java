import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2023_신기한소수_최효빈 {

    static int N;
   public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //System.out.println(isPrime(25));
        primeOfWonder(2, 1);
        primeOfWonder(3,1);
        primeOfWonder(5, 1);
        primeOfWonder(7, 1);
        System.out.println(sb);
        br.close();
    }

    public static void primeOfWonder(int prevPrime, int n){

        if(n == N){
            sb.append(prevPrime + "\n");
            return;
        }

        //짝수는 무조건 소수가 아니므로 홀수에 대해서만 반복 연산 수행
        for (int i = 1; i < 10; i+=2) {
            int target = prevPrime * 10 + i;
            if(isPrime(target)) primeOfWonder(target,n+1);
        }



    }

    public static boolean isPrime(int num){ //소수인지 검증하는 불리언 메서드
        if(num < 2) return false;
        //25가 참이 뜨는 이유는?
        for (int i = 2; i <= Math.sqrt(num); i++) {
            //부등호 -> 등호
            if (num % i == 0) return false;
        }
        return true;
    }
}
