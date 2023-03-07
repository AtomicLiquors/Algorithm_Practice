package page2;

class Person {
    //x
    public String name ="person";

    void say() {
        System.out.println("Hi!");
    }
}

class Teacher extends Person {
    public String name ="override";

    @Override
    void say() {
        System.out.println("Hello!");
    }
}


public class TeacherTest {
    public static void main(String[] args) {

        Person teacher = new Teacher();
        System.out.println(teacher.name);
    }
}

