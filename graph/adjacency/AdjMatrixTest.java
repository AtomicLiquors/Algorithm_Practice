package graph.adjacency;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest {

    static int[][] adjMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        adjMatrix = new int[V][V]; //모두 0으로 초기화된 상태

        StringTokenizer st = null;
        int from, to;
        for (int i = 0; i < E; ++i) {
            from = sc.nextInt(); //from 정점
            to = sc.nextInt(); //to 정점

            adjMatrix[to][from] = adjMatrix[from][to] = 1;
            //무향 그래프 : 대칭을 시켜서 동시에 값을 넣어준다.

            //adjMatrix[from][to] = 1;
            //유향 그래프라면 이렇게만.

        }

        print();
    }

    static void print() {
        for (int[] am : adjMatrix) {
            System.out.println(Arrays.toString(am));
        }
    }

}