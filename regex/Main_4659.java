package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean result = str.matches(".*[aeiou].*");

            if(str.matches(".*([aeiou]{3}|[^aeiou]{3}).*"))
                result = false;
            // "모음 또는 자음 3번 반복"
            // ([aeiou]|[^aeiou]){3}는 안 된다. {3}는 '똑같은 문자의 반복'을 의미하지 않으며, 저렇게 쓸 경우 자음 모음이 섞여도 패턴과 일치하는 것으로 판정된다.

            if(str.matches(".*([^eo])\\1.*"))
                result = false;
            // "e, o 제외 똑같은 문자 2번 반복" : 그룹 표현인 \1을 사용한다.
            // Java에서는 Escape 때문에 역슬래시를 두 번 붙인다.
            // 반드시 () 표시로 그룹을 만들어줘야 사용 가능한 방법.

            sb.append('<').append(str).append("> is ");
            if(!result) sb.append("not ");
            sb.append("acceptable.\n");

        }
        System.out.print(sb);
    }
}
