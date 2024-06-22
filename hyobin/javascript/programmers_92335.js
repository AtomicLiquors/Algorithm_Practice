function solution(n, k) {
    let count = 0;
    let curr = 0;
    let mult = 1;
    
    while(n >= 1){
        let rem = n % k;
        curr += (rem * mult);
        
        if(rem === 0){
            count += isPrime(curr) ? 1 : 0;
            curr = 0;
            mult = 1;
        }else{
            mult *= 10;    
        }
        
        n = Math.floor(n/k);
    }
    count += isPrime(curr) ? 1 : 0;
    
    return count;
} 

function isPrime(num){
    if(num < 2) return false;
    for(let i = 2; i <= Math.sqrt(num); i++){
        if(num % i == 0) return false;
    }
    return true;
}
