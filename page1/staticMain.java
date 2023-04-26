package page1;

import java.io.IOException;

//o
class staticTest {
    static int cv = 1;
    int iv = 1;

    static {
        cv = 2;
    }

    {
        iv = 2;
    }

    staticTest() {
        iv = 3;
    }
}

public class staticMain {

    public static void main(String[] args) throws IOException {
        staticTest t = new staticTest();
        System.out.println(staticTest.cv + " " + t.iv);
    }
}