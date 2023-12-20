// 직사각형 넓이 구하기
// for in은 배열에 대해서는 인덱스를 순환한다. 사용법을 혼동하지 말자.

function solution(dots) {
    let result = 0;
    
    let x1 = 257;
    let x2 = 257;
    let y1 = 257;
    let y2 = 257;
    
    let xGap;
    let yGap;
    
    for (let i = 0; i < dots.length; i++) {
        if( x1 === 257 ) x1 = dots[i][0];
        else if ( x1 !== dots[i][0]) x2 = dots[i][0];
        if( y1 === 257 ) y1 = dots[i][1];
        else if ( y1 !== dots[i][1]) y2 = dots[i][1];
        
    }
    xGap = x1 - x2;
    yGap = y1 - y2;
    return Math.abs(xGap * yGap);
}


/*set 활용*/
/*
const solution = dots => {
    const x = [...new Set(dots.map(p => p[0]))]
    const y = [...new Set(dots.map(p => p[1]))]
    return Math.abs((x[0] - x[1]) * (y[0] - y[1]))
}
*/

/*3개의 꼭지점만 활용한 한줄 코드*/
// var s=Math.abs,solution=([[a,b],[c,d],[e,f]])=>s(a-(a==c?e:c))*s(b-(b==d?f:d));
