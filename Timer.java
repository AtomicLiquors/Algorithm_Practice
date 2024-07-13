public class Timer {

    public static void main(String[] args) {
        long start = System.nanoTime(); //10억분의 1초 단위
        foo();
        long end = System.nanoTime();
        System.out.println((end - start) / 1_000_000_000.0); //1초로 변환
    }

    static void foo() {

    }
}


