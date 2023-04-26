package page1.interface1;

//x
interface Inf1{
    void mi1();
}

interface Inf2 {
    void mi2();
}

interface Inf3 extends Inf1, Inf2 {
    void mi3();
}


class A {
    public void mc1() { System.out.println("mc1()"); }
}

class B extends A implements Inf3 {
    public void mi1() {
        System.out.println("mi1()");
    }

    public void mi2() {
        System.out.println("mi2()");
    }

    public void mi3() {
        System.out.println("mi3()");
    }
}

public class InterfaceTest{
    public static void main(String[] args) {
        Inf1 i1 = new B();
        Inf2 i2 = (Inf2) i1;
        i2 = (Inf3) i1;

        A a = (A) i1;
        B b = (B) i1;

     //i1.mi2(); //1
     //i2.mi1(); //2
//     a.mc1(); //3
//     b.mi3(); //4
//     b.mc1(); //5

        a = new A();

        try {
//         b = (B) a; //6
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
//     System.out.println(i1 instanceof B); //7
//     System.out.println(a instanceof B); //8
    }
}