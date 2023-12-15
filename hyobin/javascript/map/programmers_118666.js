// 성격유형 검사하기
function solution(survey, choices) {
    const types = ["R", "T", "C", "F", "J", "M", "A", "N"];
    const map = new Map();

    types.forEach((key) => {
      map.set(key, 0);
    });
    
    
    const add = (value) => {
        return Math.abs(4 - value);
    }
    
    const decide = (type1, type2) => {
        let result1 = map.get(type1);
        let result2 = map.get(type2);

        if( result1 >= result2 )
            return type1;
        else 
            return type2;
    }
    
    for(let i = 0; i < survey.length; i++){
        let target;
        if(choices[i] < 4){
            target = survey[i].charAt(0);
            map.set(target, map.get(target) + add(choices[i]));
        }else if (choices[i] > 4){
            target = survey[i].charAt(1);
            map.set(target, map.get(target) + add(choices[i]));
        }
    }
    
    let answer = '';
    answer += decide("R", "T");
    answer += decide("C", "F");
    answer += decide("J", "M");
    answer += decide("A", "N");
    return answer;
    
}
