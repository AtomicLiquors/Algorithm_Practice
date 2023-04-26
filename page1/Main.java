package page1;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        //iTest();
        //wrapperTest();
        //stringTest();
        sumAdd();
        //twoDimensionArray();
        //stackTest();
    }

    static void iTest() {
        //x
        int i = 99;
        System.out.println(i--);
        System.out.println(i);
        System.out.println(--i);
        System.out.println(i);
        System.out.println((i--));
        System.out.println(i);
        System.out.println((--i));
        System.out.println(i);
        System.out.println(i / 2);
        System.out.println(i);
        System.out.println((i--) / 2);
        System.out.println(i);
        System.out.println((--i) % 2);
        System.out.println(i);
    }

    static void wrapperTest() {
        //x
        int a = 10;
        Integer b = new Integer(a);
        Integer c = 10;
        Integer d = new Integer(10);

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == d);
        System.out.println(b == c);
    }

    static void stringTest() {
        //oooooooo
        String s1 = "JAVA";
        String s2 = new String("JAVA");

        System.out.println("== : " + (s1 == s2 ? true : false));
        System.out.println("equals : " + (s1.equals(s2)));
    }

    static void sumAdd() {
//x
        int sum = 0;
        for (int i = 0; i < 10; i++) sum += i;
        System.out.println(sum);

        sum = 0;
        for (int i = 9; i > 0; i--) sum += i;
        System.out.println(sum);

        sum = 0;
        for (int i = 0; i < 10; ++i) sum += i;
        System.out.println(sum);

        sum = 0;
        for (int i = 10; i > 0; i--) sum += i;
        System.out.println(sum);
    }

    static void twoDimensionArray() {
        //x
        int[][] outer = new int[3][1];
        int[] inner = {1, 2, 3};
        for (int i = 0; i < outer.length; i++) {
            for (int j = 0; j < inner.length; j++) {
                inner[j] *= 6;
            }
            outer[i] = inner;
        }
        System.out.println(Arrays.deepToString(outer));
    }

    static void stackTest(){
        //x
        Stack<int[]> stack = new Stack<>();
        int[] temp = new int[2];
        int count = 1;

        while (count < 10) {
            temp[0] = count * 2;
            temp[1] = count * 3;
            stack.push(temp);
            count++;
        }
        while (!stack.isEmpty()) {
            int[] t = stack.pop();
            System.out.print("t[0] = " + t[0] + " ");
            System.out.println("t[1] = " + t[1] + " ");
        }
    }

}
