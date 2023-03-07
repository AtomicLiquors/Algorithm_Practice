package page1.employee;

class Employee {
    //o
    static String skill = "work hard";
    String dept = "Accounting";

    void getDept() {
        System.out.println(dept);
    }

    static void getskill() {
        System.out.println(skill);
    }
}

class Engineer extends Employee {
    static String skill = "play hard";
    String dept = "IT";

    void getDept() {
        System.out.println(dept);
    }

    static void getskill() {
        System.out.println(skill);
    }

    public static void main(String[] args) {
        Employee e = new Engineer();
        e.getDept();
        e.getskill();
        System.out.println(e.dept);
    }
}
