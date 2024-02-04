const solution = (myStr) => {
    
    const answer = [];
    
    for( stra of myStr.split("a")){
        for( strb of stra.split("b")){
            for(strc of strb.split("c")){
                if(strc !== "")
                    answer.push(strc);
            }
        }
    }
    return answer.length > 0 ? answer : ["EMPTY"];
}

// 정규 표현식을 사용할 줄 알라.
// 모범답안 : const solution=s=>s.match(/[^a-c]+/g)||['EMPTY']
