package page2;

import java.io.IOException;

public class Practice02 {
    //x
    public static void main(String args[]) {
        try {
            getNumber(-1);
            System.out.println("0&");
        } catch (IOException ne) {
            System.out.println("gg");
        } finally {
            System.out.println("gq");
        }
        System.out.println("g0");
    }

    static void getNumber(int age) throws IOException {
        if (age < 0) throw new IOException();
        System.out.println("끼잉");
    }
}

