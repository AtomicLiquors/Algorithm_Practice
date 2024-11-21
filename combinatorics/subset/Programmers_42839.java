package combinatorics.subset;

public class Programmers_42839 {
    int answer = 0;
    int len;
    int[] arr;
    boolean[] selected;
    boolean[] cache = new boolean[(int)Math.pow(10, 8)];

    public int solution(String numbers) {

        len = numbers.length();
        arr = new int[len];
        for(int i = 0; i < len; i++){
            arr[i] = numbers.charAt(i) - '0';
        }

        selected = new boolean[len];

        subset(0, 0);

        return answer;
    }

    boolean isPrime(int number){
        if (number == 2)
            return true;

        if(number < 2 || number % 2 == 0)
            return false;

        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    void subset(int cnt, int sum){
        if(cnt == len){
            if(!cache[sum]){
                cache[sum] = true;
                if(isPrime(sum))
                    answer++;
            }
            return;
        }


        for(int i = 0; i < len; i++){
            if(!selected[i]){
                selected[i] = true;
                subset(cnt+1, sum * 10 + arr[i]);
                selected[i] = false;
                subset(cnt+1, sum);
            }
        }

    }
}