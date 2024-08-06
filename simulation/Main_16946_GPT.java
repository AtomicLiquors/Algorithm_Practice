package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16946_GPT {
    static int[] dR = {0, 0, -1, 1};
    static int[] dC = {-1, 1, 0, 0};

    static int[][] ids, map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ids = new int[N][M];
        map = new int[N][M];
        Map<Integer, Integer> movementPerIds = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        StringBuilder sb = new StringBuilder();

        int id = 0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] == 0 && ids[r][c] == 0) {
                    movementPerIds.put(++id, bfs(r, c, id));
                }
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (map[r][c] > 0) {
                    Set<Integer> uniqueIds = new HashSet<>();
                    int sum = 1;
                    for (int k = 0; k < 4; k++) {
                        int nr = r + dR[k];
                        int nc = c + dC[k];
                        if (!isOuttaBound(nr, nc) && map[nr][nc] == 0) {
                            int currId = ids[nr][nc];
                            if (uniqueIds.add(currId)) {
                                sum += movementPerIds.get(currId);
                            }
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int bfs(int sr, int sc, int id) {
        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[]{sr, sc});
        ids[sr][sc] = id;

        int count = 0;
        while (!que.isEmpty()) {
            int[] curr = que.poll();
            int r = curr[0], c = curr[1];
            count++;

            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dR[dir];
                int nc = c + dC[dir];

                if (!isOuttaBound(nr, nc) && map[nr][nc] == 0 && ids[nr][nc] == 0) {
                    ids[nr][nc] = id;
                    que.offer(new int[]{nr, nc});
                }
            }
        }
        return count;
    }

    static boolean isOuttaBound(int r, int c) {
        return r < 0 || c < 0 || r >= N || c >= M;
    }
}

