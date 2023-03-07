package page2.actor;

//Actor 클래스
public class Actor extends Person {
    public int count1;
    public static int count3;

    public Actor(String name) {
        super(name);
        count1++;
        count3++;
    }

    public String toString() {
        return this.name + " is Actor!\n" + "count1 : " + count1 + " count3 : " + count3;
    }
}
