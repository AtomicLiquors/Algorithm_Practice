function solution(n, tops) {
    const D = [];
    D[0] = D[1] = 1;
        

    for (let i = 2; i <= 2 * n + 1; i += 2) {
        D[i] = (tops[i / 2 - 1] == 1 ? D[i - 2] + D[i - 1] * 2 : D[i-2] + D[i-1]);
        D[i + 1] = (D[i - 1] + D[i]) % 10007;
    }

    return D[2 * n + 1];
}
