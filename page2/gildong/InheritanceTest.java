package page2.gildong;

class Parent {
    public String name = "홍길동";

    public Parent() {
        System.out.println("부모 생성자 1 " + name);
    }

    public Parent(String name) {
        this();
        this.name = name;
        System.out.println("부모 생성자 2 " + name);
    }
}

class Child extends Parent {
    private String name;

    public Child() {
        this("고길동");
        System.out.println("자식 생성자 1 " + name);
    }

    public Child(String name) {
        super(name);
        this.name = name;
        System.out.println("자식 생성자 2 " + name);
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        new Child("아무개");
    }

    //o
}