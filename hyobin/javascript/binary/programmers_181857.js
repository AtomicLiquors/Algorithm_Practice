function solution(arr) {
    let curr = arr.length;
    let mask = 1;
    while(mask < curr){
        mask = mask << 1;
    }
    while(++curr <=  mask){
        arr.push(0);
    }
    return arr;
}

/* 모범답안 : 로그 이용 */
function solution(arr) {
  const length = arr.length;
  const totalLength = 2 ** Math.ceil(Math.log2(length));
  return [...arr, ...new Array(totalLength - length).fill(0)];
}
