package DP.knapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int tc = 0;


        int costs[] = new int[N+1];
        int memories[] = new int[N+1];
        // 문제에서 구하는 답은 '최소 비용'이다.
        // 하지만 동적 테이블의 값을 최소 비용으로 채우려면 2차원 배열을 Integer.max로 채워야 한다는 점, M의 크기가 10,000,000에 달한다는 점이 걸린다.
        // 일반적인 Knapsack과 달리 동적 테이블의 값을 최대 메모리로 채우고, 비용을 축으로 사용하는 역발상이 필요하다.

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            tc += costs[i];
        }

        int[][] D = new int[N+1][tc + 1];
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++){
            for (int j = 0; j <= tc; j++) {
                if(j >= costs[i]){
                    D[i][j] = Math.max(
                            D[i-1][j],
                            D[i-1][j - costs[i]] + memories[i]
                    );
                    if(D[i][j] >= M) answer = Math.min(answer, j);
                }else{
                    D[i][j] = D[i-1][j];
                }

            }
        }

        System.out.println(answer);
    }
}

// 틀렸습니다 1
/*
for (int i = 1; i <= N; i++){
        for (int j = costs[i]; j <= 100; j++) {
        D[i][j] = Math.max(D[i-1][j], D[i][j - costs[i]] + memories[i]);


               if(i == N && D[i][j] >= M){
                   answer = D[i][j];
                   break;
               }

        }
        }
 */
// 빠진 케이스가 있나? 정답 출력 조건을 변경, 이전 답변과 일일이 Math.min으로 비교하도록

// 틀렸습니다 2
/*
        for (int i = 1; i <= N; i++){
        for (int j = costs[i]; j <= 100; j++) {
        D[i][j] = Math.max(D[i-1][j], D[i][j - costs[i]] + memories[i]);

        if(D[i][j] >= M) answer = Math.min(answer, j);

        }
        }
*/
// -> max의 두번째 인수를 D[i-1]이 아닌 D[i]로 변경, 이번 회차에서 갱신된 최대 메모리 반영하도록.
// 적은 비용을 소모하는 다음 회차에서 D[i-1]이 0이 될 수도 있다.
// 그러려면 D[i][j]가 0이어선 안되며, 이전 회차를 반영해야 한다.

// 틀렸습니다 3 : 1%
// 현재 알고리즘을 갖고는 '불가능한 조합'을 이용한 답이 나올 수도 있겠다.

// 틀렸습니다 4
/*
*
        for (int i = 1; i <= N; i++){
            for (int j = 1; j <= 100; j++) {
                if(j >= costs[i]){
                    D[i][j] = Math.max(
                            D[i-1][j],
                            (j - costs[i] == 0 || D[i][j - costs[i]] > 0 ? D[i][j - costs[i]] + memories[i] : 0)
                    );
                    if(D[i][j] >= M) answer = Math.min(answer, j);
                }else{
                    D[i][j] = D[i-1][j];
                }
            }
        }
        * */

// 틀렸습니다 88%
/*
  st = new StringTokenizer(br.readLine());
          for (int i = 1; i <= N; i++) {
          costs[i] = Integer.parseInt(st.nextToken());
          tc += costs[i];
          // 비용의 총합을 산정해 준다.
          }

          int[][] D = new int[N+1][tc + 1];
          int answer = Integer.MAX_VALUE;

          for (int i = 1; i <= N; i++){
          for (int j = 1; j <= tc; j++) {
          // 3. 비용의 총합은 100을 넘을 수 있다.
          if(j >= costs[i]){
          D[i][j] = Math.max(
          D[i-1][j],
          D[i-1][j - costs[i]] + memories[i]
          // 1. 두번째 인수에서 D[i]에서 탐색하는 게 아니라 D[i-1]에서 탐색한다.
          );

          }else{
          D[i][j] = D[i-1][j];
          }
          if(D[i][j] >= M) answer = Math.min(answer, j);
          // 2. 정답을 갱신하는 로직을 밖으로 뺀다. 왜?
          }
          }
          */


// 정답 : 비용은 0부터 시작해야 한다.
/*
  st = new StringTokenizer(br.readLine());
          for (int i = 1; i <= N; i++) {
          costs[i] = Integer.parseInt(st.nextToken());
          tc += costs[i];
          // 비용의 총합을 산정해 준다.
          }

          int[][] D = new int[N+1][tc + 1];
          int answer = Integer.MAX_VALUE;

          for (int i = 1; i <= N; i++){
          for (int j = 1; j <= tc; j++) {
          // 3. 비용의 총합은 100을 넘을 수 있다.
          if(j >= costs[i]){
          D[i][j] = Math.max(
          D[i-1][j],
          D[i-1][j - costs[i]] + memories[i]
          // 1. 두번째 인수에서 D[i]에서 탐색하는 게 아니라 D[i-1]에서 탐색한다.
          );
  if(D[i][j] >= M) answer = Math.min(answer, j);
  // 여기서 정답을 갱신하는 게 맞다. else 상황에서는 항상 비용이 더 비쌀 수밖에 없으니까.
          }else{
          D[i][j] = D[i-1][j];
          }

          }
          }
          */
