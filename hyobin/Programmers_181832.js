
function solution(n) {


    const dR = [0, 1, 0, -1];
    const dC = [1, 0, -1, 0];

    let value = 1;

    const answer = [];
    let dir = 1;

    let newArray;
    for(let i = 0; i < n; i++){
        (newArray = []).length = n;
        newArray.fill(0);
        answer.push(newArray);
    }

    for(let i = 0; i < n; i++){
        answer[0][i] = value;
        value++;
    }

    let currR = 0;
    let currC = n-1;

    let moves = n - 1;
    while(moves > 0){
        for(let i = 0 ; i < 2; i++){
            for(let j = 0; j < moves; j++){
                currR += dR[dir];
                currC += dC[dir];
                answer[currR][currC] = value;
                value++;
            } 
            dir = (dir + 1) % 4;   
        }
        moves--;
    }

    return answer;
}
