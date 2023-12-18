// 개인정보 수집 유효기간
// 변수명을 명확히 해야 틀렸을 때 수정이 된다.
function solution(today, terms, privacies) {
    const todayToString = today.split(".");
    
    const todayY = Number(todayToString[0]);
    const todayM = Number(todayToString[1]);
    const todayD = Number(todayToString[2]);
    
    const contract = new Map();
    
    let key, value;
    terms.forEach( (term) => {
        const [key, value] = term.split(' ');
        contract[key] = Number(value);
    })
    
    const answer = [];
    
    let year, day, month;
    let years, days, months;
    let term, gap;
    for(let i = 0; i < privacies.length; i++){
        const [date, type] = privacies[i].split(' ');
        const prvDateToString = date.split('.');
        
        year = Number(prvDateToString[0]);
        month = Number(prvDateToString[1]);
        day = Number(prvDateToString[2]);
        
        term = contract[type];
        
        years = ( todayY - year );
        
        months = todayM - month;     
        
    
        days = ( todayD - day );
        if (days < 0) months--;
        
        gap = years * 12 + months;
        
        if (gap >= term)
            answer.push(i+1);
    }
    
    return answer;
}
