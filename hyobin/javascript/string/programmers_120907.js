
// OX퀴즈
function solution(quiz) {
    var answer = [];
    for(let i = 0; i < quiz.length; i++){
        const items = quiz[i].split(' ');
        
        let n1 = Number(items[0]);
        let op = items[1];
        let n2 = Number(items[2]);
        let result = Number(items[4]);
        
        let correct = false;
        if(op === "+"){
            correct =  ( (n1 + n2 === result) ? true : false );
        }else{
            correct =  ( (n1 - n2 === result) ? true : false );
        }

        answer.push( correct ? "O" : "X");
    }
    
    return answer;
}
