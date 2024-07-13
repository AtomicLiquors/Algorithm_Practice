package greedy;

import java.util.*;

class programmers_138476 {
    /*
    public int solution(int k, int[] tangerine) {
        // 갯수가 많은 놈부터 담으면 그게 정답이다.
        // 귤의 크기 종류 수가 총 몇 개냐?
        int[] cache = new int[10000001];
        for(int t : tangerine){
            cache[t]++;
        }
        Arrays.sort(cache);

        int cnt = 0;
        int pt = 10000001;
        while(k > 0){
            pt--;
            if(cache[pt] == 0)    
                continue;

            cnt++;
            k -= cache[pt];
        }

        return cnt;
    }

     */
}
