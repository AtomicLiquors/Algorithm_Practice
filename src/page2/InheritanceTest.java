package page2;

class Parent {
    public Parent() {
        System.out.println("Parent");
    }
}

class Children extends Parent {

    static {
        System.out.println("static block");
    }

    {
        System.out.println("instance block");
    }

    public Children() {
        super();
        System.out.println("Children");
    }
}

public class InheritanceTest{
    public static void main(String[] args) {
        new Children();
    }
    //x
}
