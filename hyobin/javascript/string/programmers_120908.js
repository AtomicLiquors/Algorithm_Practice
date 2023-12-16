// 문자열 안에 문자열.
function solution(str1, str2) {
    let len = str2.length;
    let answer = 2;
    for(let i = 0; i <= str1.length; i++){
      // To-Do : 등호를 빼면 오답이 발생하는 이유를 증명하지 않음.
        let start = i;
        let end = i + len - 1;
        
        let flag = true;
        
        while(start <= end){
            
            if(str1[start] !== str2[start - i] || str1[end] !== str2[end - i]){
                flag = false;
                break;
            }
            
            start++;
            end--;
        }
        
        if(flag){
            answer = 1;
            break;
        }
    }
    
    return answer;
}
/* 시간 초과 코드 */
/*
function solution(str1, str2) {
    let len = str2.length;
    let answer = 2;
    for(let i = 0; i < str1.length - len; i++){
        let start = i;
        let end = i + len -1;
        
        let flag = true;
        
        while(start <= end){
            if(str1.charAt(start) !== str2.charAt(start - i)){
                flag = false;
                break;
            }
            if(str1.charAt(end) !== str2.charAt(end - i)){
                flag = false;
                break;
            }
        }
        
        if(flag){
            answer = 1;
            break;
        }
    }
    
    return answer;
}
*/
