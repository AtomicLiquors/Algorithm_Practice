package Leetcode;

class Solution_ThirdMaxNumber {
    public int thirdMax(int[] nums) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        
        boolean minAppeared = false;
        
        int num;
        int cnt = 0;
        for(int i = 0; i < nums.length; i++){
            num = nums[i];
            if(num == first || num == second || num == third){
                if(num == Integer.MIN_VALUE && !minAppeared){
                    minAppeared = true;
                    cnt++;
                }
                continue;
            } 
            cnt++;

            if(first < num){
                third = second;
                second = first;
                first = num;
                
            }else if(second < num){
                third = second;
                second = num;
            }else if(third < num){
                third = num;
            }
        }
        
        return cnt<3?first:third;
    }
}

//모범답안 : https://leetcode.com/problems/third-maximum-number/solutions/90202/java-neat-and-easy-understand-solution-o-n-time-o-1-space/
