package string;

import java.util.*;

class Programmers_81301 {
    public int solution(String s) {
        
        Map<String, Integer> map  = new HashMap<>() {{
            put("zero", 0);
            put("one", 1);
            put("two", 2);
            put("three", 3);
            put("four", 4);
            put("five", 5);
            put("six", 6);
            put("seven", 7);
            put("eight", 8);
            put("nine", 9);
        }};
        
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for(char c : s.toCharArray()){
            
            int num = c - '0';
            if(num < 10) 
                answer = addToEnd(answer, num);
            else{
                sb.append(c);
                if(map.get(sb.toString()) != null){
                    answer = addToEnd(answer, map.get(sb.toString()));
                    sb = new StringBuilder();
                }
            }            
        }
        return answer;
    }
    
    int addToEnd(int origin, int additive){
        return origin * 10 + additive;
    }
}

/* 모범답안 */
/*
class Solution {
    String answer;
    public int compare(char ch, int i, String s){
        switch(ch){
            case 'z' :
                answer += "0";
                return 3;
            case 'o' :
                answer += "1";
                return 2;
            case 'e' :
                answer += "8";
                return 4;
            case 'n' :
                answer += "9";
                return 3;
            case 't' :
                if(s.charAt(i+1)=='w'){
                    answer += "2";
                    return 2;
                }else{
                    answer += "3";
                    return 4;
                }
            case 'f' :
                if(s.charAt(i+1)=='o'){
                    answer += "4";
                    return 3;
                }else{
                    answer += "5";
                    return 3;
                }
            case 's' :
                if(s.charAt(i+1)=='i'){
                    answer += "6";
                    return 2;
                }else{
                    answer += "7";
                    return 4;
                }
        }
        return 0;
    }
    public int solution(String s) {
        answer = "";

        String temp = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                int jump = compare(ch,i,s);
                i += jump;
            }else{
                answer += ch;
            }

        }

        return Integer.parseInt(answer);
    }
}
*/
