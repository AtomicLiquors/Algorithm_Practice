package page2;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        type();
        integer();
        twoDimensionArray();

//        boo();
        //count();

        stringTest();

//        exceptionTest();
    }

    static void type() {
        int n1 = -4;
        int n2 = n1 >> 1;
        int n3 = n1 >>> 1;
        System.out.printf("%x -> %d\n", n1, n1);
        System.out.printf("%x -> %d\n", n2, n2);
        System.out.printf("%x -> %d\n", n3, n3);
    }

    static void integer() {
        Integer num1 = (Integer) 100;
        Integer num2 = (Integer) 100;
        Integer num3 = (Integer) 500;
        Integer num4 = (Integer) 500;
        if (num1 == num2) {
            System.out.println("num1 == num2");
        } else {
            System.out.println("num1 != num2");
        }
        if (num3 == num4) {
            System.out.println("num3 == num4");
        } else {
            System.out.println("num3 != num4");
        }

    }

    static void twoDimensionArray() {
        String[] stringArray = {"1", "2", "3"};
        int[][] intArray = {{1}, {2}, {3}, {4}};
        for (String s : stringArray) {
            s += "1";
        }

        for (int[] r : intArray) {
            r[0] += 1;
        }
        for (int i = 0; i < 3; i++) System.out.print(stringArray[i] + " ");
        for (int i = 0; i < 4; i++) System.out.print(intArray[i][0] + " ");
    }

    static void joylish(){
        String str = "joylish";
        int i=0;
        while(i<str.length())
        {    System.out.println(str.charAt(++i));
        }
    }
    /*
    static void boo(){
        boolean boo=true;
        switch(boo) {
            case true:
                System.out.print("똘똘이");
            case false:
                System.out.print("짹짹이");
                break;
            default:
                System.out.print("쫄랑이");
        }
    }//o
*/

/*
  static void count(){
        char c1;
        char c2 = '1';
        int count = 0;
        while(c1 < '9') {
            c1 = c2 + 2;
            count += 1;
        }
        System.out.println(count);
    }
*/


    static void stringTest() {
        String[] text = new String[10];
        for (int i = 0; i < 9; i++) {
            System.out.println(text[i].equals(text[i + 1]));
        }
        //[x]
    }

/*
    static void exceptionTest(){
        try {
            throw new NoSuchElementException();
        } catch ( Exception e ) {
            System.out.println("Exception!");
        } catch ( NoSuchElementException e ) {
            System.out.println("No Such Element Exception!");
        } finally {
            System.out.println("Finally!");
        }
    }*/

}
