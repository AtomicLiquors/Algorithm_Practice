package page2;

public class StaticMethodTest {
    //o

    static void run1() {
        System.out.println("Hello 1");
    }

    static void run2() {
        System.out.println("Hello 2");
    }

    public static void main(String[] args) {
        run1();
        run2();
        new StaticMethodTest().run1();
        new StaticMethodTest().run2();
    }

}