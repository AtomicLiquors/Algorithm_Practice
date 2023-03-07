package page2.name;

public class Main {
    public static void main(String[] args) {

        String str = "abc";
        System.out.println(str);
        edit(str);
        System.out.println(str);

        Person p = new Person("김재환");
        System.out.println(p);
        edit(p);
        System.out.println(p);

        //o
    }

    public static void edit(String str) {
        str = "def";
    }

    public static void edit(Person p) {
        p.setName("유재환");
    }
}
