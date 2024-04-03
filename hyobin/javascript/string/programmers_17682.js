// .match(/\d+/g); : 정수만 추출한 배열 리턴.
// match는 배열을 리턴함을 유의하라.
// *는 역슬래시 붙이기.

/*
  [switch 대신 객체 활용하기]
   const bonus = { 'S': 1, 'D': 2, 'T': 3 },
         options = { '*': 2, '#': -1, undefined: 1 };
*/
function solution(dartResult) {
    const scores = dartResult.match(/\d+/g);
    const commands = dartResult.split(/\d+/g).splice(1);
    let answer = 0;
    let prev = 0;
    
    scores.map((item, idx) => {
        const weight = getWeight(commands[idx]);
        
        const option = commands[idx].match(/\*|#/);
        
        let score = Math.floor(Math.pow(scores[idx], weight));
        
        if(option){
            switch(option[0]){
                case "\*":
                    score *= 2;
                    answer += prev;
                    break;

                case "#":
                    score *= -1;
                    break;
            }
        }
        
        answer += prev = score;
    })
    
    return answer;
}


function getWeight(command){
    switch(command.match(/S|D|T/)[0]){
        case "S":
            return 1;
        case "D":
            return 2;
        case "T":
            return 3;
        default:
            return 1;
    }
}
