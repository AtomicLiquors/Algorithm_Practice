function solution(my_string, m, c) {
    const strings = [];
    let pointer = 0;
    while(pointer < my_string.length){
        strings.push(my_string.slice(pointer, pointer + m));
        pointer += m;    
    }
    
    return strings.reduce((acc, value) => {acc += value[c-1]; return acc;}, "");
}
