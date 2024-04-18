function solution(absolutes, signs) {
    return absolutes.reduce((sum, item, idx) => sum + item * (signs[idx]?1:-1), 0);
}
