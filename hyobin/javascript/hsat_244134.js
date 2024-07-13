const fs = require('fs');
const N = +fs.readFileSync(0).toString().trim();

console.log(solve(N));

function solve(num){
    if(num === 0)
        return 4;

    return ( solve(num-1) - Math.pow(2, num-1) ) * 4 - 3;
}
