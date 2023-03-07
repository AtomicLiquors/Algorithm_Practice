package page2.actor;

// Person 클래스
public class Person {
    public String name;
    public int count1;
    public static int count2;

    public Person(String name) {
        this.name = name;
        count1++;
        count2++;
    }

    public String toString() {
        return this.name + " is Person~\n" + "count1 : " + count1 + " count2 : " + count2;
    }
}
