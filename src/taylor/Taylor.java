package taylor;

public class Taylor {

    final static double PI = Math.PI;

    public static void main(String[] args) {

        double resultS = sin(10* PI, 15);
        double resultC = cos(PI, 15);
        double resultT = tan(PI, 15);
        System.out.println(resultS);
        System.out.println(resultC);
        System.out.println(resultT);

    }

    static double sin(double x, int termCount){
        if(x < 0) return -sin(-x, termCount);

        while(x >= 2* PI) x-= 2* PI;

        double currentTerm = x;
        double estimated = currentTerm;
        for(int n = 1; n < termCount; n++){
            currentTerm *= -x*x / (2*n*(2*n + 1));
            estimated += currentTerm;
        }
        return estimated;
    }

    static double cos(double x, int termCount){
        if(x < 0) return cos(-x, termCount);

        while(x >= 2* PI) x-= 2* PI;

        double currentTerm = 1;
        double estimated = currentTerm;
        for(int n = 1; n < termCount; n++){
            currentTerm *= -x*x / (2*n*(2*n - 1));//-1로 변경
            estimated += currentTerm;
        }
        return estimated;
    }

    static double tan(double x, int termCount){
        return sin(x, termCount) / cos(x, termCount);
    }
}
