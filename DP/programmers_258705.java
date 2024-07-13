package DP;

class programmers_258705 {
    public int solution(int n, int[] tops) {
        int[] D = new int[2 * n + 2];
        D[0] = D[1] = 1;

        for (int i = 2; i <= 2 * n + 1; i += 2) {
            D[i] = (tops[i / 2 - 1] == 1 ? D[i - 2] + D[i - 1] * 2 : D[i-2] + D[i-1]);
            D[i + 1] = (D[i - 1] + D[i]) % 10007;
        }

        return D[2 * n + 1];
    }
}
