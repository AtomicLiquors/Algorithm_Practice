package page2.name;

//Person 클래스
public class Person {
    public String name;
    public Person (String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public String toString(){
        return this.name;
    }
}
