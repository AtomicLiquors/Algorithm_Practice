package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 게리맨더링
public class BOJ_17471 {

    static int N;
    static int numbersToSelect;
    static boolean[][] adjMatrix;
    static boolean[] visited;
    static int[] population;

    static boolean[] isBlue;

    static int blueCount;
    static int redCount;
    static int currPopulation, totalPopulation;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        totalPopulation = 0;

        population = new int[N+1];
        adjMatrix = new boolean[N+1][N+1];
        isBlue = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            totalPopulation += population[i];
        }

        int curr;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            while (st.hasMoreTokens()){
                curr = Integer.parseInt(st.nextToken());
                adjMatrix[i][curr] = true;
            }
        }

        answer = Integer.MAX_VALUE;
        for (int n = 1; n <= N/2; n++) {
            numbersToSelect = n;
            comb(1, 0);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void comb(int start, int cnt){
        if(cnt == numbersToSelect){
            visited = new boolean[N+1];
            blueCount = 0;
            redCount = 0;

            currPopulation = 0;
            for (int i = 1; i <= N; i++) {
                if(isBlue[i] && blueCount == 0){
                    blueCount = countAdjByDFS(i, true);
                }else if(!isBlue[i] && redCount == 0){
                    redCount = countAdjByDFS(i, false);
                }
                if(blueCount > 0 && redCount > 0){
                    if(blueCount == numbersToSelect && redCount == N - numbersToSelect){
                        answer = Math.min(answer, Math.abs(2 * currPopulation - totalPopulation));
                    }
                    break;
                }
            }
            return;
        }

        for (int i = start; i <= N; i++) {
            isBlue[i] = true;
            comb(i+1, cnt+1);
            isBlue[i] = false;
        }
    }

    static int countAdjByDFS(int curr, boolean isCheckingBlue){
        int sections = 1;
        visited[curr] = true;

        if(isCheckingBlue) currPopulation += population[curr];

        for (int i = 1; i <= N; i++) {
            if(adjMatrix[curr][i] && !visited[i] && (isBlue[curr] == isBlue[i]))
                sections += countAdjByDFS(i, isCheckingBlue);
        }

        return sections;
    }

}
