// 신고 결과 받기

/* 내 답안 */
function solution(id_list, report, k) {
    const userMap = new Map();
    
    for(let id of id_list){
        userMap.set(id, {
                mailCount: 0,
                reporterMap: new Map(), 
                reportCount: 0, 
                reporterArr: []
            }
        )
    }
    
    for(let reportDetail of report){
        let detail = reportDetail.split(" ");
        let reporter = detail[0];
        let target = detail[1];
        
        let userInfo = userMap.get(target);
        if(!userInfo.reporterMap.get(reporter)){
            userInfo.reporterMap.set(reporter, true);
            userInfo.reporterArr.push(reporter);
            userInfo.reportCount++;
            
        }
    }
    
    const answer = [];
    
    for(let id of id_list){
        let userInfo = userMap.get(id);
        if(userInfo.reportCount >= k){
            for(let rep of userInfo.reporterArr){
                userMap.get(rep).mailCount++;
            }
        }
    }
    
    for(let id of id_list){
        answer.push(userMap.get(id).mailCount);
    }
    return answer;
}


/*
//모범답안 : set은 기본형 타입에 대해 중복을 제거하는 용도로 사용될 수 있다.
function solution(id_list, report, k) {
    let reports = [...new Set(report)].map(a=>{return a.split(' ')});
    let counts = new Map();
    for (const bad of reports){
        counts.set(bad[1],counts.get(bad[1])+1||1)
    }
    let good = new Map();
    for(const report of reports){
        if(counts.get(report[1])>=k){
            good.set(report[0],good.get(report[0])+1||1)
        }
    }
    let answer = id_list.map(a=>good.get(a)||0)
    return answer;
}
*/
