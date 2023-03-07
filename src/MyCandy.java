import java.util.*;

public class MyCandy {



    public static void main(String[] args) {
        Queue<Integer[]> queue = new LinkedList<>();
        int candy = 20;

        int num = 0;

        while (true){
            num += 1;
            queue.add(new Integer[]{num, 1});
            System.out.println(queue.toString());

            int v = queue.peek()[1];
            if (v == 1) candy -= 1;
            else candy -= ( v * ( v - 1 ));
            System.out.println(candy);

            Integer[] returner = queue.poll();
            if(candy < 0) {
                System.out.println("last visitor : " + returner[0]);
                break;
            }
            returner[1]++;
            queue.add(returner);
        }
    }
}

