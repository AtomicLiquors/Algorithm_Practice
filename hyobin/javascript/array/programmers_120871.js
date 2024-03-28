function solution(n) {
    
    const arr = [];
    arr[0] = 0;
    for(let i = 1; i <= n; i++){
        let value = (arr[i-1] + 1);
        let valueStr = value + "";
        while(value % 3 === 0 || valueStr.split("3").length > 1){
            value++;
            valueStr = value + "";
        }
            
        arr[i] = value;
    }
    return arr[n];
}
