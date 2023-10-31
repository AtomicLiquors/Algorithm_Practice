package Algorithm_Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SsafyIn {
    /*
    * [취업은 운칠기삼]
    * 때로 좌절도 하지만 극복도 하고, 결국 경험이 반복되며 나의 역량은 무한정 쌓여갑니다.
    */
    static boolean isFrustrated = false;
    static float frustrationPossibility = 0.5f;
    static float overcomePossibility = 0.2f;
    static int ability = 0;
    static boolean employed = false;

    static void frustrate() {
        if(Math.random() > frustrationPossibility)
            isFrustrated = true;
    }

    static void experience() {
        ability++;
        if(Math.random() > overcomePossibility)
            isFrustrated = false;
    }

    public static void main(String[] args) throws IOException {

        int luck, force;

        while(!employed){

            luck = (int) (Math.random() * 7) + 1;
            force = ( isFrustrated ? 0 : Math.min(3, ability) );

            if(luck + force < 10){
                System.out.println("귀하의 우수한 역량에도 불구하고, 아쉽게도 이번 전형에 불합격하셨습니다.");
                frustrate();
                experience();
            }else{
                employed = true;
            }
        }

        System.out.printf("지금까지 %d만큼의 역량을 쌓아오셨습니다! \n 귀하의 앞날에 무궁한 발전을 기원합니다.", ability);
    }
}
