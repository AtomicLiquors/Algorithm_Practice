// 양꼬치
function solution(n, k) { 
  return n * 12000 + (k - Math.floor(n/10)) * 2000; 
}

/* tilt 이용 답변 */
/*
function solution(n, k) {
    k -= ~~(n/10); // 
    if (k < 0) k = 0;
    return n*12000+k*2000;
}
*/

/*
tilt는 "32비트 정수 변환 후 NOT연산자를 실행"하는 연산자며,
tilt를 두 번 호출할 경우 소숫점을 버리는 효과가 나타난다.
단 정수 부분이 1씩 깎이는 Math.floor와는 달리, 음수일 경우에도 정수 부분이 원래대로 유지된다.
*/
