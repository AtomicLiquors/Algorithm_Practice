package page1.polymorphism;

//x
class Person {
}

class SpiderMan extends Person {
    void fireweb() {
        System.out.println("거미줄 발사!");
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        SpiderMan sman = (SpiderMan) person;
        sman.fireweb();
    }
}

