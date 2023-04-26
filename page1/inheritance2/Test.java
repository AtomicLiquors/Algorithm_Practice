package page1.inheritance2;

//x
class Parent {
    {
        System.out.println("Parent Init");
    }

    Parent() {
        System.out.println("Parent Const");
    }
}

class Child extends Parent {
    {
        System.out.println("Child Init");
    }

    Child() {
        System.out.println("Child Const");
    }
}

public class Test {
    public static void main(String[] args) {
        new Child();
    }
}