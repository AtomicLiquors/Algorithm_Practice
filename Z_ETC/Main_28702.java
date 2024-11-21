package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = 0;

        for (int offset = 3; offset > 0; offset--) {
            try{
                int i = Integer.parseInt(br.readLine());
                target = i + offset;
            }catch(NumberFormatException e){
                continue;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(target % 3 == 0)
            sb.append("Fizz");
        if(target % 5 == 0)
            sb.append("Buzz");
        System.out.print(sb.toString().equals("") ? target : sb);
    }
}
