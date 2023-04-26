package page1;

//[vo]
class Parent {
    static int a = 0;

    static {
        a++;
    }

    Parent() {
        a++;
    }
}



public class Test {
    public static void main(String[] args) {
        new Parent();
        System.out.println(Parent.a);
        new Parent();
        System.out.println(Parent.a);
    }
}

