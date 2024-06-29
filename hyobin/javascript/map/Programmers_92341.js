function solution(fees, records) {
    timeThreshold = fees[0]; 
    basicFee = fees[1];
    unitTime = fees[2];
    unitFee = fees[3];
    
    var answer = [];
    const timeMap = new Map();
    const feeMap = new Map();
    
    records.map((record) =>{
        const parsedRecord = record.split(" ");
        const time = parsedRecord[0].split(":");
        const timeValue = +time[0] * 60 + +time[1];
        const key = +parsedRecord[1];
        const isIn = parsedRecord[2] === "IN";
        
        if(!feeMap.get(key)) 
            feeMap.set(key, 0);
        
        if(isIn){
            timeMap.set(key, timeValue);
        }else{
            const time = timeValue - timeMap.get(key);
            feeMap.set(key, feeMap.get(key) + time);
            timeMap.delete(key);
        }
    }); 
    
    for(const entry of [...timeMap.entries()]){        
        const key = +entry[0];
        const time = (23 * 60 + 59) - +entry[1];
        feeMap.set(key, feeMap.get(key) + time);
    }
    
    const sortedByNumber = [...feeMap.entries()].sort((a, b) => a[0] - b[0]);
    
    const result = sortedByNumber.map((item) => 
        charge(item[1], fees[0], fees[1], fees[2], fees[3])
    );
    return result;
}

function charge(time, timeThreshold, basicFee, unitTime, unitFee){
    let fee = basicFee;
    if(timeThreshold < time){
        fee += ( unitFee * Math.ceil( (time - timeThreshold) / unitTime ) );
    }
    return fee;
}
