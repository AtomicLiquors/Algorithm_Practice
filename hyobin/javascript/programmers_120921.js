// 문자열 밀기

function solution(A, B) {
    
    let jStart = 0;
    
    let answer = -1;
    const len = A.length;
    
    let flag = false;
    while(jStart < len){
        flag = true;
        let j = jStart;
        for(let i = 0; i < len; i++){
            
            if(A[i] !== B[j]){
                flag = false;
                break;
            }
            if(++j >= len) 
                j = 0;
        }
        if(!flag)
            jStart++;
        else
            break;
    }
    return flag ? jStart : -1;
}

// 모범답안
/*
let solution=(a,b)=>(b+b).indexOf(a)
// 다만 시간은 오래 걸립니다.

실제로 icon을 한 파일 안에 모아놓고 left, top, width, height만 css에서 줘서 한 icon만 보여주게 하거나, 
슬라이딩 방식의 광고에서 2개를 연결해서 지나가게 하면 마지막 뒤의 첫번째가 자연스럽게 오는 예시 등에서 사용되는 로직입니다.
*/

// 모범답안2
/*
function solution(A, B) {
    if (A===B) return 0;
    for (let i = 0; i < A.length; i++) {
        A = A.slice(-1) + A.slice(0,-1);
        if (A === B) return i+1;
    }
    return -1;
}

*/
