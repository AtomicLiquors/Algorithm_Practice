package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int answer, N;
    static int startR, startC;
    static int size = 2;
    static int consumed;
    static int[][] map;
    static boolean[][] visited;

    static int[] dR = { -1, 0, 0, 1};
    static int[] dC = { 0, -1, 1, 0 };


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    startR = i;
                    startC = j;
                }

            }
        }

        while (true) {
            int cnt = BFS();

            if (cnt == 0) break;
            answer += cnt;
        }

        System.out.println(answer);

    }

    private static int BFS() {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        int minDist = Integer.MAX_VALUE;

        Queue<int[]> que = new ArrayDeque<>();
        visited = new boolean[N][N];

        visited[startR][startC] = true;
        que.offer(new int[]{startR, startC, 0});

        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int r = curr[0];
            int c = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dR[d];
                int nc = c + dC[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] > size) continue;

                int currDist = curr[2] + 1;
                if (map[nr][nc] != 0 && map[nr][nc] < size) {
                    if (currDist < minDist) {
                        minR = nr;
                        minC = nc;
                        minDist = currDist;
                    } else if (currDist == minDist) {
                        if (nr < minR) {
                            minR = nr;
                            minC = nc;
                            minDist = currDist;
                        } else if (nr == minR) {
                            if (nc < minC) {
                                minR = nr;
                                minC = nc;
                                minDist = currDist;
                            }

                        }

                    }
                }

                visited[nr][nc] = true;
                que.offer(new int[]{nr, nc, currDist});
            }
        }

        if (minDist == Integer.MAX_VALUE) return 0;
        consumed++;

        if (consumed == size) {
            size++;
            consumed = 0;
        }

        map[minR][minC] = 0;
        map[startR][startC] = 0;

        startR = minR;
        startC = minC;

        return minDist;

    }
}
