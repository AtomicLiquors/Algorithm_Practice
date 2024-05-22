function solution(s, skip, index) {
    
    const shouldSkipLetter = [];
    
    for(const skipLetter of skip){
        shouldSkipLetter[skipLetter.charCodeAt(0)] = true;
    }
    
    let str = "";
    
    for(const letter of s){
        let target = letter.charCodeAt(0);
        let rem = index;
        
        while(--rem >= 0){
            target = increaseCode(target);
            while(shouldSkipLetter[target]){
                target = increaseCode(target);
            }    
        }
        
        
        str += String.fromCharCode(target);
    }
    
    return str;
}

function increaseCode(n){
    n++;
    if(n > 122) n = 97;
    return n;
}
