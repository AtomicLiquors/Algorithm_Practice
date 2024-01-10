import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[][] paper;

    private static int[] sum(int[] a, int[] b, int[] c, int[] d) {
        return new int[] {a[0] + b[0] + c[0] + d[0], a[1] + b[1] + c[1] + d[1]};
    }

    private static boolean isSingleColor(int x, int y, int size) {
        int color, i, j;

        color = paper[x][y];
        for (i = x; i < x + size; i++) {
            for (j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[] count(int x, int y, int size) {
        int half = size / 2;

        if (isSingleColor(x, y, size)) {
            if (paper[x][y] == 0) {
                return new int[] {1, 0};
            } else {
                return new int[] {0, 1};
            }
        }
        return sum(count(x, y, half), count(x, y + half, half), count(x + half, y, half), count(x + half, y + half, half));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n, i, j;
        int[] cnt;

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = count(0, 0, n);
        sb.append(cnt[0]).append('\n').append(cnt[1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
