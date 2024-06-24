package regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char firstLetter = st.nextToken().charAt(0);
            if(firstLetter == '*')
                break;

            boolean result = true;
            while(st.hasMoreTokens()){
                String pattern = "(?i)" + firstLetter + ".*";
                if(!st.nextToken().matches(pattern)){
                    result = false;
                    break;
                }
            }
            sb.append(result ? 'Y' : 'N').append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
