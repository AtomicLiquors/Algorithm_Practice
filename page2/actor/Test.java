package page2.actor;

public class Test {
    public static void main(String args[]) {
        Person[] people = new Person[4];
        people[0] = new Person("Jaemoon");
        people[1] = new Actor("Minkue");
        people[2] = new Actor("Jongwan");
        people[3] = new Person("Jisoo");

        for (Person p : people) {
            System.out.println(p);
        }
    }
}