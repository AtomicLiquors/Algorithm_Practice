class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for(int i = 1; i < s.length(); i++){
            answer = Math.max(palindrome(s, i-1, i, 0), answer);
            answer = Math.max(palindrome(s, i-1, i+1, 1), answer);
        }

        return answer;
    }

    public int palindrome(String s, int left, int right, int cnt){

        while(left >= 0 && right < s.length()){
            if(s.charAt(left) != s.charAt(right))
                break;
            cnt += 2;
            left--;
            right++;
        }

        return cnt;
    }
}
