function solution(array, commands) {
    return commands.map(
        (cmd) => array.slice(cmd[0]-1, cmd[1]).sort((a, b) => a-b)[cmd[2]-1]
    );
}
/*.sort()는 기본적으로 "문자열 정렬"이므로 [10, 2]를 정렬하면 [2, 10]이 아닌 [10, 2]를 리턴한다.*/
