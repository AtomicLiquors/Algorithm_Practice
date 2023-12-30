// 영어가 싫어요
    
function add(answer, num){
    return answer * 10 + num;
}

function solution(numbers) {
    let pt = 0;
    let answer = 0;
    
    while(pt < numbers.length){
        switch(numbers[pt]){
            case 'z':
                answer = add(answer, 0);
                pt += 4;
                break;
            case 'o':
                answer = add(answer, 1);
                pt += 3;
                break;
            case 't':
                pt++;
                if(numbers[pt] == 'w'){
                    answer = add(answer, 2);
                    pt += 2;
                }else if(numbers[pt] == 'h'){
                    answer = add(answer, 3);
                    pt += 4;
                }
                break;
            case 'f':
                pt++;
                if(numbers[pt] == 'o'){
                    answer = add(answer, 4);
                    pt += 3;
                }else if(numbers[pt] == 'i'){
                    answer = add(answer, 5);
                    pt += 3;
                }
                break;
            case 's':
                pt++;
                if(numbers[pt] == 'i'){
                    answer = add(answer, 6);
                    pt += 2;
                }else if(numbers[pt] == 'e'){
                    answer = add(answer, 7);
                    pt += 4;
                }
                break;
            case 'e':
                answer = add(answer, 8);
                pt += 5;
                break;
            case 'n':
                    answer = add(answer, 9);
                pt += 4;
                break;
            default:
                break;
        }
    }
    return answer;
}

/* 모범답안 */
// replace 활용
/*
function solution(numbers) {
    let numStr = [ "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" ];

    numStr.forEach((str, idx) => {
        numbers = numbers.replaceAll(str, idx);
    });
    return Number(numbers);
}
*/

// 인덱스 활용
//var solution=n=>Number(['zero','one','two','three','four','five','six','seven','eight','nine'].reduce((t,s,i)=>t.replaceAll(s,i),n))

// replace에 두번째 인수로 콜백함수
/*
function solution(numbers) {
    const obj = {
        zero: 0, one: 1, two: 2, three: 3, four: 4,
        five: 5, six: 6, seven: 7, eight: 8, nine: 9
    };

    const num = numbers.replace(/zero|one|two|three|four|five|six|seven|eight|nine/g, (v) => {
        return obj[v];
    });

    return Number(num);
}
*/
