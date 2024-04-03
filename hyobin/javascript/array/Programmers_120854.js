/* 맵은 단순히 콜백함수를 실행만 할 뿐만 아니라 그 결과를 저장한 배열을 반환한다. */
function solution(strlist) {
    return strlist.map((el) => el.length)
}
