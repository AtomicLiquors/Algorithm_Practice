package Algorithm_Practice.disjointset;

import java.io.*;
import java.util.StringTokenizer;

public class Main_연결요소의개수 {
    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        int cnt = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(Union(a, b)) cnt--;

        }
        bw.write(cnt);
        bw.flush();

    }

    static int findSet(int a) {
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean Union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }
}
