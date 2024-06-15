function solution(arr)
{
    var answer = [];
    answer.push(arr[0]);
    let idx = 0;

    for(const elem of arr){
       if(answer[idx] != elem){
           answer.push(elem);
           idx++;
          
        }
    }
    
    return answer;
}

/*
function solution(arr)
{
    return arr.filter((val,index) => val != arr[index+1]);
}

*/
