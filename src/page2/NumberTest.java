package page2;

import java.util.HashMap;
import java.util.Map;

class Number {
    int i;

    Number(int i) {
        this.i = i;
    }

    public int hashcode() {
        return i % 3;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Number)) return false;
        return (i % 2) == ((Number) obj).i % 2;
    }
}

public class NumberTest {
    public static void main(String[] args) {
        Map<Number, Integer> m = new HashMap<>();
        for (int i = 0; i <= 9; i++) {
            m.put(new Number(i), 1);
        }
        System.out.println(m.size());
    }
}