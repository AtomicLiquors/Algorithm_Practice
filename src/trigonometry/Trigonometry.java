package trigonometry;

public class Trigonometry {

    public static void main(String[] args) {
        int[] start = {1, 1};
        int[] end = {2, 2};
        //좌표평면상의 두 점

        int a = Math.abs(end[0] - start[0]);
        int b = Math.abs(end[1] - start[1]);
        //두 점 사이 x거리, y 거리

        double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

        double radian = Math.atan(b/a);
        double degree = Math.toDegrees(radian);


        System.out.println(radian);
        System.out.println(degree);
    }
}
