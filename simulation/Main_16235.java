package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Tree implements Comparable<Tree>{

    int r;
    int c;
    int age;

    Tree(int r, int c, int age){
        this.r = r;
        this.c = c;
        this.age = age;
    }

    void grow(){
        this.age++;
    }

    @Override
    public int compareTo(Tree t) {
        return this.age - t.age;
    }
}

public class Main_16235 {

    static int N, M, K, N1;

    static int[] dR = {-1,-1,-1,0,0,1,1,1};
    static int[] dC = {-1,0,1,-1,1,-1,0,1};
    static int[][] A, trees, nutes;

    static PriorityQueue<Tree> pq;
    static Queue<Tree> aliveTrees, deadTrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        N1 = N + 1;

        nutes = new int[N1][N1];
        A = new int[N1][N1];

        pq = new PriorityQueue<>();
        aliveTrees = new ArrayDeque<>();
        deadTrees = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                nutes[i][j] = 5;
            }
        }


        int x, y, z;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());
            pq.offer(new Tree(x, y, z));
        }

        for (int i = 0; i < K; i++) {
            springAndAutumn();
            summer();
            winter();
        }

        System.out.println(aliveTrees.size());
    }

    static void springAndAutumn(){
        while(!aliveTrees.isEmpty()){
            pq.offer(aliveTrees.poll());
        }
        while(!pq.isEmpty()){
            Tree t = pq.poll();
            if(feed(t)){
                t.grow();
                aliveTrees.offer(t);

                // autumn
                if(t.age % 5 == 0)
                    reproduce(t);
            }
            else
                deadTrees.offer(t);
        }

    }

    static void summer(){
        while(!deadTrees.isEmpty()){
            Tree dt = deadTrees.poll();
            nutes[dt.r][dt.c] += dt.age / 2;
        }
    }
    static void winter(){
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                nutes[i][j] += A[i][j];
            }
        }
    }

    static boolean feed(Tree t){
        if(nutes[t.r][t.c] < t.age){
            return false;
        } else {
            nutes[t.r][t.c] -= t.age;
            return true;
        }
    }

    static void reproduce(Tree t){
        int nr, nc;
        for (int i = 0; i < 8; i++) {
            nr = t.r + dR[i];
            nc = t.c + dC[i];
            if(nr < 1 || nc < 1 || nr > N || nc > N)
                continue;
            aliveTrees.offer(new Tree(nr, nc, 1));
        }
    }
}
