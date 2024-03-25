const solution = (array) => {
    const cache = [];
    let max = 0;
    let selected = 0;
    for (let item of array){
        if(!cache[item])
            cache[item] = 0;
        let curr = cache[item];
        curr = cache[item] = curr + 1;
        
        if(curr === max){
            selected = -1;
        }else if(curr > max){
            max = curr;
            selected = item;
        }    
    }
    return selected;
}

/*
function solution(array) {
    let m = new Map();
    for (let n of array) m.set(n, (m.get(n) || 0)+1);
    m = [...m].sort((a,b)=>b[1]-a[1]);
    return m.length === 1 || m[0][1] > m[1][1] ? m[0][0] : -1;
}
*/
