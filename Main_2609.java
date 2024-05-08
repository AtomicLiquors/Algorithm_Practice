import java.util.Scanner;

public class Main_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        int a = A, b = B;
        int rem = 1;
        int gdc;
        while(true){
            rem = a % b;
            if(rem == 0){
                gdc = a;
                break;
            }

            a = b;
            b = rem;
        }

        System.out.println(gdc);
        System.out.println(A * B / gdc);

        sc.close();
    }


}
