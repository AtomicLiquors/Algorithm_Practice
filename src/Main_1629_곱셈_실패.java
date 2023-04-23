import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_1629_곱셈_실패 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int curr = A%C;
        List<Integer> list = new ArrayList<>();

        list.add(curr);

        boolean flag = false;
        for (int i = 0; i < 10; i++) {
            //System.out.println(curr);
            curr *= A;
            curr %= C;
            for (int j = 0; j < list.size(); j++) {
                if(curr==list.get(j))
                    flag = true;
            };
            if(flag) break;
            list.add(curr);
        }

        B %= list.size();
        System.out.println(list.get(B));
    }
}
