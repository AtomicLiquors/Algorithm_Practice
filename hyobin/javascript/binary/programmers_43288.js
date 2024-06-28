// 입국심사
function solution(N, times) {

    times.sort((a, b) => { return a - b});
    
    let left = times[0];
    let right = N * times[times.length-1];
    let answer = Number.MAX_VALUE;
    
    let mid, sum;
    
    while(left <= right){
        mid = Math.floor((left + right) / 2);
        
        sum = times.reduce((acc, time) => {
            return acc + Math.floor(mid / time); 
        }, 0);
        
        console.log(sum);
       if(sum >= N){
            answer = Math.min(answer, mid);
            right = mid-1;
        }else{
            left = mid+1;
        }
    }
  
    return answer;
}

// 이진탐색, reduce 올바른 활용
