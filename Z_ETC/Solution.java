package Z_ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {

    static int[] parents;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            makeSet(N);

            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                union(a, b);
            }

            int result = 0;
            for (int i = 1; i <= N; i++) {
                if(parents[i]==-1) result++;
            }

            System.out.printf("#%d %s\n", tc, result);
        }


    }

    static void makeSet(int N){
        parents = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parents[i] = -1;
        }
    }

    static int findSet(int a){
        if(parents[a] == -1) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
