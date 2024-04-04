function solution(strings, n) {
    return strings.sort((a, b) => a.charCodeAt(n) - b.charCodeAt(n) || a.localeCompare(b));
}
// 문자열 배열을 특정 인덱스에 대해 정렬하고 같은 값이면 일반 기준으로 정렬.
